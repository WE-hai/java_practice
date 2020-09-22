package 题目3;

import java.util.Scanner;

public class Main {
    public int daycost (int len, int m, int n) {
        int[] dp = new int[len];
        for (int i = 0;i < len;i++) {
            dp[i] = dp[i-1]+m;
            if (dp[i] > len) {
                dp[i] -= n;
            } else {
                return i;
            }
        }
        return -1;
    }
    public static int method(int m,int n) {
        int[] dp = new int[m*100];
        int huaSum = 0;
        for (int i = 0;i < m*100;i++) {
            dp[i] = dp[i-1]+n;
            huaSum += n/(2^i);
            if (dp[i] > m*100) {
                dp[i] -= huaSum;
            } else {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(method(m,n));
        }
    }
}
