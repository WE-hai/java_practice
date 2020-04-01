package 汽水瓶问题;

import java.util.Scanner;

public class Main {
    public static int drink(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 2 || n == 3) {
            return 1;
        } else {
            int h = n/3;
            return h+drink(n-3*h+h);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            System.out.println(drink(n));
        }
    }
}
