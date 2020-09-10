package 题目2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0;i < s.length();i++) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    sb1.append(i);
                }
                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    sb2.append(i);
                }
            }
            int l = (sb1.length()+sb2.length())/2;
            int t = 0;
            if (sb1.length() > sb2.length()) {
                t = l-sb1.length();
            } else {
                t = l-sb2.length();
            }
            System.out.println(t);
        }
    }
}
