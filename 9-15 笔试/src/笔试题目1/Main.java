package 笔试题目1;

import java.util.Scanner;

public class Main {
    public static int[] primeFactorization(int num) {
        int[] arr = new int[num];
        if (num%2 == 0) {
            arr[0] = num;
            return arr;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _num;
        _num = Integer.parseInt(in.nextLine().trim());

        res = primeFactorization(_num);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}
