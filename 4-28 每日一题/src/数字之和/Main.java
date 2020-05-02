package 数字之和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = n*n;
            int sum1 = 0;
            int sum2 = 0;
            while (n > 0) {
                sum1 += n%10;
                n /= 10;
            }
            while (m > 0) {
                sum2 += m%10;
                m /= 10;
            }
            System.out.println(sum1+" "+sum2);
        }
    }
}
