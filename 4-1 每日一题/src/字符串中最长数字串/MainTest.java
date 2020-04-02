package 字符串中最长数字串;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            for (int i = 0; i < str.length(); i++) {
                char a = str.charAt(i);
                if (!Character.isDigit(a)) {
                    str = str.replace(str.charAt(i), ' ');
                }
            }
            str = str.trim();
            String[] arrs = str.split(" ");
            int max = 0;
            for (int i = 0; i < arrs.length; i++) {
                if (arrs[i].length() != 0) {
                    if (Character.isDigit(arrs[i].charAt(0))) {
                        max = Math.max(max, arrs[i].length());
                    }
                }
            }
            for (int i = 0; i < arrs.length; i++) {
                if (arrs[i].length() != 0) {
                    if (arrs[i].length() == max) {
                        System.out.print(arrs[i]);
                    }
                }
            }
            System.out.print(',');
            System.out.println(max);
        }
    }
}
