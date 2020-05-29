package 连续最大和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < arr.length;i++) {
                arr[i] = scanner.nextInt();
            }
            int sum = arr[0];
            int max = arr[0];
            for (int i = 1;i < arr.length;i++) {
                if (sum >= 0) {
                    sum += arr[i];
                } else {
                    sum = arr[i];
                }
                if (max < sum) {
                    max = sum;
                }
            }
            System.out.println(max);
        }
    }
}
