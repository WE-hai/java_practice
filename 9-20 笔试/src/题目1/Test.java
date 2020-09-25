package 题目1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            int count = 0;
            for (int i = 0;i < ch1.length;i++) {
                for (int j = 0;j < ch2.length;j++) {
                    if (ch1[i] == ch2[j]) {
                        count++;
                        ch2[j] = ' ';
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
