package 找x;

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
            int x = scanner.nextInt();
            for (int i = 0;i < arr.length;i++) {
                if (x == arr[i]) {
                    System.out.println(i);
                    return;
                }
            }
            System.out.println(-1);
        }
    }
}
