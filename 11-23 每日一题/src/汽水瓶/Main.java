package 汽水瓶;

// f(n)=n/3 + f(n%3+n/3)，貌似递归次数更少。
// n/3是能直接换到的汽水数，n%3+n/3是新换到的汽水瓶子+上次换剩下的

import java.util.*;

public class Main {

    public static int f(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        return n / 3 + f(n % 3 + n / 3);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num != 0) {
                System.out.println(f(num));
            }
        }
        sc.close();
    }
}