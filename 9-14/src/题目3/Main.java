package 题目3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] arr = new int[1000];
            for (int i = 0;i < arr.length;i++) {
                arr[i] = scanner.nextInt();
            }
            if (arr.length < 5) {
                int sum = 0;
                for (int i = 0;i < arr.length;i++) {
                    sum += arr[i];
                }
                System.out.println(sum);
            }
            int[] a = new int[5];
            int[] b = new int[5];
            for (int i = 0;i < 5;i++) {
                a[i] = arr[i];
                b[i] = arr[arr.length-1-i];
            }

        }
    }
}
