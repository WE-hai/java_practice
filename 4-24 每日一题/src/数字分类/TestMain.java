package 数字分类;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        int num1 = 0, num2 = 0, num3 = 0, num5 = 0, n = 1;
        float b = 0.0f;
        float num4 = 0.0f;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
            if ((array[i] % 5 == 0) && (array[i] % 2 == 0)) {//能被5整除并且为偶数
                num1 += array[i];
            }
            if (array[i] % 5 == 1) { //将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
                num2 = num2 + n * array[i];
                n = (-1) * n;
            }
            if (array[i] % 5 == 2) {
                num3++;
            }//被5除后余2的数字的个数；
            if (array[i] % 5 == 3) {
                num4 = num4 + array[i];// 被5除后余3的数字的平均数，精确到小数点后1位；
                b++;
            }//求平均数
            if (array[i] % 5 == 4) {//被5除后余4的数字中最大数字。
                if (array[i] > num5) {
                    num5 = array[i];
                }
            }
        }
        if (num1 == 0) {
            System.out.print("N ");
        } else System.out.print(num1 + " ");
        if (num2 == 0) {
            System.out.print("N ");
        } else System.out.print(num2 + " ");
        if (num3 == 0) {
            System.out.print("N ");
        } else System.out.print(num3 + " ");
        if (num4 == 0) {
            System.out.print("N ");
        } else System.out.print((float) (int) (num4 / b * 10 + 0.5) / 10 + " ");
        if (num5 == 0) {
            System.out.print("N ");
        } else System.out.print(num5);
    }
}