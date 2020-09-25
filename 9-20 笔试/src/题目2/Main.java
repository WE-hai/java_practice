package 题目2;

import java.util.Scanner;

public class Main {
    public static String isJudge(String s) {
        String[] strings = new String[s.length()/3];
        for (int i = 0;i < strings.length;i++) {
            for (int j = 0;j < strings.length;j++) {
                strings[j] = s.substring(i, i + 3);
            }
        }
        String str = strings[0];
        for (int i = 0;i < strings.length;i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j < str.length();j++) {
                if (strings[i].charAt(j) == str.charAt(j)) {
                    sb.append(str.charAt(j));
                }
            }
            if (sb.length() >= 2) {
                return "Yes";
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            String[] strings = new String[T];
            for (int i = 0;i < T;i++) {
                strings[i] = scanner.nextLine();
            }
            String ret = "";
            for (int i = 0;i < T;i++) {
                if (strings[i].length()%3 != 0) {
                    System.out.println("No");
                }
                ret = isJudge(strings[i]);
                System.out.println(ret);
            }
        }
    }
}
