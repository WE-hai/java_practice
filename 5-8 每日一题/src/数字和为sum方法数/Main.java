package 数字和为sum方法数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < arr.length;i++) {
                arr[i] = scanner.nextInt();
            }
            long[] array = new long[sum+1];
            array[0] = 1;
            for (int i = 0;i < arr.length;i++) {
                for (int j = sum;j >= 0;j--) {
                    if (j >= arr[i]) {
                        array[j] += array[j-arr[i]];
                    }
                }
            }
            System.out.println(array[sum]);
        }
    }
}
