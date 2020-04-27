package 到底买不买;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int count = 0;
        for (int i = 0;i < s2.length();i++) {
            char ch1 = s2.charAt(i);
            for (int j = 0;j < s1.length();j++) {
                char ch2 = s1.charAt(j);
                if (ch1 == ch2) {
                    count++;
                    break;
                }
            }
        }
        if (count == s2.length()) {
            System.out.println("Yes"+" "+(s1.length()-count));
        } else {
            System.out.println("No"+" "+(s2.length()-count));
        }
    }
}
