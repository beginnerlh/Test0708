
/*
开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
处理:
1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，
错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，
而只是文件名的后16个字符和行号相同，也不要合并)
3.输入的文件可能带路径，记录文件名称不能带路径

输入描述:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
文件路径为windows格式
如：E:\V1R2\product\fpgadrive.c 1325

输出描述:
将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
如果超过8条记录，则只输出前8条记录.
如果文件名的长度超过16个字符，则只输出后16个字符
示例1
输入
E:\V1R2\product\fpgadrive.c 1325
输出
fpgadrive.c 1325 1
*/
package written_test0708;

import java.util.*;
//简单错误记录
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        while(in.hasNext()){
            String[] strs = (in.next()).split("\\\\");
            String name = strs[strs.length-1];//获取文件名
            name= name+" "+in.next();
            int index = names.indexOf(name);
            if(index != -1){//存在
                num.set(index,num.get(index)+1);
            }else{
                names.add(name);
                num.add(1);
            }
        }

        String[] namestmp = new String[names.size()];//文件名
        names.toArray(namestmp);//将集合转换为数组
        Integer[] nums = new Integer[num.size()];//每个文件对应的个数
        num.toArray(nums);
        //排序
        for(int i=0; i<namestmp.length; i++){
            int maxindex = i;
            for(int j=i+1; j<namestmp.length; j++){
                if(nums[j] > nums[maxindex]){
                    maxindex = j;
                }
            }
            //根据文件对应的个数，交换文件位置，然后再把文件个数位置交换
            String name1 = namestmp[maxindex];
            System.arraycopy(namestmp,i,namestmp,i+1,maxindex-i);
            namestmp[i] = name1;
            Integer sum1 = nums[maxindex];
            System.arraycopy(nums,i,nums,i+1,maxindex-i);
            nums[i] = sum1;
        }
        //输出
        for(int i=0; i<Math.min(namestmp.length,8); i++){
            String name = namestmp[i];
            String a = name.split(" ")[0];
            String b = name.split(" ")[1];
            //文件名长度大于16  截取后16位
            if(a.length()>16){
                name = a.substring(a.length()-16)+" "+b;
            }
            System.out.println(name+" "+nums[i]);
        }
    }
}