package 斐波那契数列;

public class Main {
    //动态规划
    public int Fibonacci(int n) {
        //初始值
        if (n <= 0) {
            return 0;
        }
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2;i <= n;i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
