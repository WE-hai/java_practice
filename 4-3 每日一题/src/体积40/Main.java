package 体积40;

import java.util.Scanner;

public class Main {
    static int count = 0;
    static int[] arr;
    static int n;
    public static void count(int s,int n) {
        if (s == 0) {
            count++;
        }
        if (s <= 0 || (s > 0 && n < 0)) {
            return;
        }
        count(s-arr[n],n-1);
        count(s,n-1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n+1];
        for (int i = 1;i <= n;i++) {
            arr[i] = scanner.nextInt();
        }
        count(40,n);
        System.out.println(count);
    }
}
