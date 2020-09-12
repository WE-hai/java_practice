package 题目1;

import java.util.Scanner;

public class Main {
    public static boolean isHui(String s) {
        for (int i = 0;i < s.length();i++) {
            for (int j = s.length()-1;j > 0;j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < s.length();i++) {
                sb.append(i);
                if (isHui(sb.toString())) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
