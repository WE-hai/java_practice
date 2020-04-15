package 正方形;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char c = scanner.next().charAt(0);
        for (int i = 0;i < (n+1)/2;i++) {
            for (int j = 0;j < n;j++) {
                if (i == 0 || j == 0 || i == ((n+1)/2 - 1) || j == n-1) {
                    System.out.print(c);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
