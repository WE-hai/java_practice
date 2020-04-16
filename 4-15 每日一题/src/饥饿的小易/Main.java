package 饥饿的小易;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x0 = scanner.nextInt();
        int count = 0;
        int ret = 0;
        while (x0 != 0 && count <= 300000) {
            x0 = ((x0*2)+1) % 1000000007;
            count++;
        }
        ret = (count + 2) / 3;
        if (ret > 100000) {
            System.out.println(-1);
        } else {
            System.out.println(ret);
        }
    }
}