package 组个最小数;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        while (scanner.hasNext()) {
            for (int i = 0;i < arr.length;i++) {
                arr[i] = scanner.nextInt();
            }
            int j = 1;
            for(;j < arr.length;j++) {
                if (arr[j] != 0) {
                    System.out.print(j);
                    arr[j] = arr[j]-1;
                    break;
                }
            }
            for(int k = 0;k < 10;k++){
                for(int m = 0;m < arr[k];m++){
                    System.out.print(k);
                }
            }
        }
    }
}
