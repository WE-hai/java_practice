package 题目1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();
            String s = scanner.nextLine();
            int x = 0, y = 0;
            for (int i = 0;i < s.length();i++) {
                if (s.charAt(i) == 'L') {
                    x -= 1;
                }
                if (s.charAt(i) == 'R') {
                    x += 1;
                }
                if (s.charAt(i) == 'U') {
                    y += 1;
                }
                if (s.charAt(i) == 'D') {
                    y -= 1;
                }
            }
            System.out.println((x-x0)+" "+(y-y0));
        }
    }
}
