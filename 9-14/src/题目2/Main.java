package 题目2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < s.length();i++) {
                if (s.charAt(i) >= '5' && s.charAt(i) <= '8') {
                    sb.append(s.charAt(i));
                } else {
                    sb.append(" ");
                }
            }
            String str = sb.toString();
            String[] split = str.split(" ");
            int max = split[0].length();
            for (int i = 1;i < split.length;i++) {
                if (split[i].length() > max) {
                    max = split[i].length();
                }
            }
            for (int i = 0;i < split.length;i++) {
                if (split[i].length() == max) {
                    System.out.print(split[i]);
                }
            }
        }
    }
}
