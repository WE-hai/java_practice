package 最小公倍数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int max = Math.max(A,B);
        int min = Math.min(A,B);
        int k = max;
        while (k%min != 0) {
            k += max;
        }
        System.out.println(k);
    }
}
