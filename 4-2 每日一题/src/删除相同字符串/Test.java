package 删除相同字符串;

import java.util.Scanner; /* 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”  */

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb1 = new StringBuilder(sc.nextLine());
        StringBuilder sb2 = new StringBuilder(sc.nextLine());
        for (int i = 0; i < sb2.length(); i++) {
            int num = 0;
            while ((num = sb1.indexOf(sb2.charAt(i) + "")) != -1) {
                sb1.deleteCharAt(num);
            }
        }
        System.out.println(sb1);
    }
}
