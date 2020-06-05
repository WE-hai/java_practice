package 合唱团;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 总人数
            int n = sc.nextInt();
            // 学生的能力值，第i个人对应第I个位置
            int[] arr = new int[n + 1];
            // 初始化
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            // 选择学生数
            int kk = sc.nextInt();
            // 间距
            int dd = sc.nextInt();
            // 规划数组
            long[][] f = new long[n + 1][kk + 1];
            long[][] g = new long[n + 1][kk + 1];
            // 初始化k=1的情况
            for (int one = 1; one < n; one++) {
                f[one][1] = arr[one];
                g[one][1] = arr[one];

            }
            // 总人数等于1 或者大于1
            if (n == 1) {
                System.out.println(arr[1]);
            } else {
                for (int k = 2; k <= kk; k++) {
                    for (int one = k; one <= n; one++) {
                        long tempmax = Long.MIN_VALUE;
                        long tempmin = Long.MAX_VALUE;
                        for (int left = Math.max(k - 1, one - dd); left <= one - 1; left++) {
                            if (tempmax < Math.max(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one])) {
                                tempmax = Math.max(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one]);
                            }
                            if (tempmin > Math.min(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one])) {
                                tempmin = Math.min(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one]);
                            }

                        }
                        f[one][k] = tempmax;
                        g[one][k] = tempmin;
                    }
                }
                long result = Long.MIN_VALUE;
                for (int one = kk; one <= n; one++) {
                    if (result < f[one][kk]) {
                        result = f[one][kk];
                    }
                }
                System.out.println(result);
            }

        }
    }

}
