package 斐波那契数列;

import java.util.Scanner;

public class Main {
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int flag1 = 0;
            int flag2 = 0;
            int i = 0;
            while (true) {
                flag2 =  fib(i);
                if (flag2 > N) {
                    break;
                 }
                flag1 = flag2;
                i++;
            }
            int ret = 0;
            if (N-flag1 < flag2-N) {
                ret = N-flag1;
            } else {
                ret = flag2-N;
            }
            System.out.println(ret);
        }
    }
}
