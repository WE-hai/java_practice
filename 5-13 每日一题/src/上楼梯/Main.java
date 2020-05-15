package 上楼梯;

public class Main {
    public static int countWays(int n) {
        if (n < 1) {
            return 0;
        }
       int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for (int i = 3;i < arr.length;i++) {
            arr[i] = ((arr[i-1] + arr[i-2])%1000000007+arr[i-3]%1000000007)%1000000007;
        }
        return arr[n-1];
    }

    public static void main(String[] args) {
        System.out.println(countWays(39));
    }
}
