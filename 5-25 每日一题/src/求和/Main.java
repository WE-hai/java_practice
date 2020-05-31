package 求和;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void sumPrint(int[] arr,int m,String s,int sum,int i) {
        if (i == arr.length) {
            if (sum == m) {
                System.out.println(s.trim());
            }
            return;
        }
        sumPrint(arr,m,s+arr[i]+" ",sum+arr[i],i+1);
        sumPrint(arr,m,s,sum,i+1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < n;i++) {
                arr[i] = i+1;
            }
            int sum = 0;
            String s = "";
            sumPrint(arr,m,s,sum,0);
        }
    }
}
