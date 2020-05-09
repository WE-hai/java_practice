package 年会抽奖;

import java.util.Scanner;

public class Main {
    public static double count(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return (n - 1) * (count(n - 1) + count(n - 2));
    }
    public static double fac(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fac(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            double p = count(n)/fac(n);
            System.out.printf("%2.2f",p*100);
            System.out.println("%");
        }
    }
}
