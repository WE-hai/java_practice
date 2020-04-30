package 小易的升级之路;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int a = in.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            int ans = getResult(a, b);
            System.out.println(ans);
        }
    }
    private static int getResult(int a, int[] b) {
        // TODO Auto-generated method stub
        // Arrays.sort(b); 注意：此处不能排序！
        for (int i = 0; i < b.length; i++) {
            if (a > b[i]) {
                a += b[i];
            } else {
                a += maxCommonDivisor(a, b[i]);
            }
        }
        return a;
    }
    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {// 在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;// 返回最大公约数
    }
}