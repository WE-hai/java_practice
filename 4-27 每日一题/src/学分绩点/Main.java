package 学分绩点;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int i = 0;i < arr1.length;i++) {
                arr1[i] = scanner.nextInt();
            }
            for (int i = 0;i < arr2.length;i++) {
                arr2[i] = scanner.nextInt();
            }
            double[] arr3 = new double[n];
            for (int i = 0;i < arr2.length;i++) {
                if (arr2[i] >= 90 && arr2[i] <= 100) {
                    arr3[i] = 4.0;
                } else if (arr2[i] >= 85 && arr2[i] <= 89) {
                    arr3[i] = 3.7;
                }else if (arr2[i] >= 82 && arr2[i] <= 84) {
                    arr3[i] = 3.3;
                } else if (arr2[i] >= 78 && arr2[i] <= 81) {
                    arr3[i] = 3.0;
                } else if (arr2[i] >= 75 && arr2[i] <= 77) {
                    arr3[i] = 2.7;
                } else if (arr2[i] >= 72 && arr2[i] <= 74) {
                    arr3[i] = 2.3;
                } else if (arr2[i] >= 68 && arr2[i] <= 71) {
                    arr3[i] = 2.0;
                } else if (arr2[i] >= 64 && arr2[i] <= 67) {
                    arr3[i] = 1.5;
                } else if (arr2[i] >= 60 && arr2[i] <= 63) {
                    arr3[i] = 1.0;
                } else {
                    arr3[i] = 0;
                }
            }
            double[] arr4 = new double[n];
            for (int i = 0;i < arr4.length;i++) {
                arr4[i] = arr1[i]*arr3[i];
            }
            int sumFen = 0;
            for (int i = 0;i < arr1.length;i++) {
                sumFen += arr1[i];
            }
            double sum = 0;
            for (int i = 0;i < arr4.length;i++) {
                sum += arr4[i];
            }
            double ret = sum/sumFen;
            System.out.printf("%.2f",ret);
        }
    }
}
