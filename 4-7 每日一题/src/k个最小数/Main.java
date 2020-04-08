package k个最小数;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] arrs = s.split(" ");
            int[] arr = new int[arrs.length-1];
            int k = 0;
            for (int i = 0;i < arrs.length;i++) {
                if (i < arrs.length-1) {
                    arr[i] = Integer.parseInt(arrs[i]);
                } else {
                    k = Integer.parseInt(arrs[i]);
                }
            }
            Arrays.sort(arr);
            for (int i = 0;i < k;i++) {
                System.out.print(arr[i]+" ");
            }
        }
    }
}
