package 体积40;

import java.util.Scanner;

public class TestMain {
    static  int[] record ;
    static  int n ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        record = new int[n];
        for (int i = 0; i < n; i++) {
            record[i]=scanner.nextInt();
        }
        int count = fun(0, 40);
        System.out.println(count);
    }
    public static int fun(int i,int sum){
        //结束
        if (i == n) {
            return 0;
        }
        //刚好够，注意，这里还可以不填充继续递归
        if (record[i] == sum) {
            return 1+fun(i+1,sum);
        } else if (sum > record[i]) {
            return fun(i+1,sum-record[i])+fun(i+1,sum);
        }
        return fun(i+1,sum);
    }
}