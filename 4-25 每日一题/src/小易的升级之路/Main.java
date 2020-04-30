package 小易的升级之路;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (m > arr[i] || m == arr[i]) {
                    m += arr[i];
                } else {
                   m += get(m,arr[i]);
                }
            }
            System.out.println(m);
        }
    }

    public static int get(int A,int B){
        if(B == 0) {
            return A;
        } else {
            return get(B, A % B);
        }
    }
}
