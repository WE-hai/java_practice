package 奇偶校验;


import java.util.Scanner;

//这一题里面将数字和字母统一看成是char类型的，
// 所以数字3实际存储时为ASCII码中的‘3’，
// 其十进制表示是51，转化为二进制表示就是0110011，取最高位为奇校验位，
// 校验位为1，所以校验后的二进制数为10110011，字母同理。
// 故本题只需将输入的字符减去‘\0’得到字符的十进制表示，
// 再将其转化为七位二进制数加上一位校验位输出即可。

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] arr = s.toCharArray();
            for (char ch : arr) {
                String s1 = Integer.toBinaryString(ch);
                String s2 = String.format("%07d",Integer.parseInt(s1));
                int count = 0;
                for (int i = 0;i < 7;i++) {
                    if (s2.charAt(i) == '1') {
                        count++;
                    }
                }
                if (count % 2 == 0) {
                    System.out.println("1"+s2);
                } else {
                    System.out.println("0"+s2);
                }
            }
        }
    }
}
