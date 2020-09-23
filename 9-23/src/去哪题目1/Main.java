package 去哪题目1;

import java.util.Scanner;

public class Main {
    public static int method(int n) {
        if (n <= 2) {
            return n;
        }
        int one = 1;
        int two = 2;
        int ret = 0;
        for (int i = 3;i <= n;i++) {
            ret = one+two;
            one = two;
            two = ret;
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(method(n));
        }
    }
}
