package 买苹果;

import java.util.Scanner;

public class Main {
    public static int appleCount(int num) {
        if (num < 0 || num > 100) {
            return -1;
        }
        for (int i = 0;i < num;i++) {
            for (int j = 0;j < num;j++) {
                if (6*i+8*j == num) {
                    return i+j;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(appleCount(num));
    }
}
