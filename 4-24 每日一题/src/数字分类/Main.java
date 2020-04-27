package 数字分类;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int A1 = 0,A2 = 0,A3 = 0,A5 = 0;
        double A4 = 0;
        int flag = 1;
        int count = 0;
        for (int i = 0;i < arr.length;i++) {
            arr[i] = scanner.nextInt();
            if (arr[i]%5 == 0 && arr[i]%2 == 0) {
                A1 += arr[i];
            }
            if (arr[i]%5 == 1) {
                A2 += arr[i]*flag;
                flag = -flag;
            }
            if (arr[i]%5 == 2) {
                A3++;
            }
            if (arr[i]%5 == 3) {
                A4 += arr[i];
                count++;
            }
            if (arr[i]%5 == 4) {
                if (arr[i] > A5) {
                    A5 = arr[i];
                }
            }
        }
        if (A1 != 0) {
            System.out.print(A1+" ");
        } else {
            System.out.print("N"+" ");
        }
        if (A2 != 0) {
            System.out.print(A2+" ");
        } else {
            System.out.print("N"+" ");
        }
        if (A3 != 0) {
            System.out.print(A3+" ");
        } else {
            System.out.print("N"+" ");
        }
        if (A4 != 0) {
            System.out.printf("%.1f ",A4/count);
        } else {
            System.out.print("N"+" ");
        }
        if (A5 != 0) {
            System.out.print(A5+" ");
        } else {
            System.out.print("N"+" ");
        }
    }
}
