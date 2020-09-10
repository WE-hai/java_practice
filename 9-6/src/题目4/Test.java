package 题目4;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int res = 0;
            int temp = 0;
            for(int i = 0;i < nums.length;i++){
                nums[i] = scanner.nextInt();
                for(int j = 1;j <= n;j++){
                    res^= (nums[i]%j);
                }
                temp = res^nums[i];
                temp ^= temp;
            }
            System.out.println(temp);
        }
    }
}