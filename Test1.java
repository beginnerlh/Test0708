/*
给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出。

输入描述:
测试输入包含一个测试用例，在一行内给出总长度不超过80的字符串。字符串由若干单词和
若干空格组成，其中单词是由英文字母（大小写有区分）组成的字符串，单词之间用1个空格分开，
输入保证句子末尾没有多余的空格。

输出描述:
每个测试用例的输出占一行，输出倒序后的句子。
示例1
输入
Hello World Here I Come
输出
Come I Here World Hello
 */
package written_test0708;

import java.util.Scanner;
//说反话

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] str = s.split(" ");
            for(int i = str.length-1;i>-1;i--){
                if(i == 0){
                    System.out.print(str[i]);
                }else{
                    System.out.print(str[i]+" ");
                }
            }
        }
    }
}