package 马戏团;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int[][] a = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            int m = getResult(N, a);
            System.out.println(m);
        }
    }
    private static int getResult(int N, int[][] a) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i][1] < a[j][1]) {
                    int b = a[i][1];
                    a[i][1] = a[j][1];
                    a[j][1] = b;
                    int c = a[i][2];
                    a[i][2] = a[j][2];
                    a[j][2] = c;
                } else if (a[i][1] == a[j][1] && a[i][2] > a[j][2]) {
                    int b = a[i][1];
                    a[i][1] = a[j][1];
                    a[j][1] = b;
                    int c = a[i][2];
                    a[i][2] = a[j][2];
                    a[j][2] = c;
                }
            }
        }
        int count[] = new int[N];
        for (int i = 0; i < N; i++) {
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j][2] >= a[i][2] && count[j] + 1 > count[i])
                    count[i] = count[j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }
        return max;
    }
}