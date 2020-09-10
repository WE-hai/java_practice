package 题目4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < n;i++) {
                arr[i] = scanner.nextInt();
            }
            int ret = 0;
            for (int i = 0;i < n;i++) {
                arr[i] = arr[i] ^ i;
                ret ^= arr[i];
            }
            System.out.println(ret);
        }
    }
}
