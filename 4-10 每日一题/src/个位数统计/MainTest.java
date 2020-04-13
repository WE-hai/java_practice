package 个位数统计;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();
        char[] chs = N.toCharArray();
        int[] arr = new int[chs.length];
        for (int i = 0;i < chs.length;i++) {
            arr[i] = (int)(chs[i]-'0');
        }
        Arrays.sort(arr);
        for (int i = 0;i < arr.length;i++) {
            int count = 0;
            for (int j = 0;j < arr.length;j++) {
                if (arr[i] == j) {
                    count++;
                }
            }
            System.out.println(arr[i]+":"+count);
        }
    }
}
