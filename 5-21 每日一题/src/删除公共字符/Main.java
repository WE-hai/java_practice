package 删除公共字符;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < s1.length();i++) {
                if (!s2.contains(s1.charAt(i)+"")) {
                    sb.append(s1.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
