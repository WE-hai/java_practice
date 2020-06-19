package Fibonacci;

public class Main {
    /**
     * 递归：O（2^n)
     */
    public int fib1(int n) {
        //初始值
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        //f(n) = f(n-1)+f(n-2)
        return fib1(n - 1) + fib1(n-2);
    }

    /**
     *动态规划
     */
    public int fib2(int n) {
        //初始值
        if (n <= 0) {
            return 0;
        }
        //申请一个数组，保存子问题的解，从0项开始
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 1;i <= n;i++) {
            //f(n) = f(n-1)+f(n-2)
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    //O(1)
    public int fib3(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int ret = 0;
        int a = 1,b = 1;
        for (int i = 3;i <= n;i++) {
            //f(n) = f(n-1)+f(n-2)
            ret = a + b;
            b = a;
            a = ret;
        }
        return ret;
    }
}
