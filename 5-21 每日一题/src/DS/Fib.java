package DS;

import java.util.*;

public class Fib {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 0;
        int b = 1;
        while(b <= n) {
            int tmp = b+a;
            a = b;
            b = tmp;
        }
        if((b-n) > (n-a)) {
            System.out.println(n-a);
        } else {
            System.out.println(b-n);
        }
    }

}
