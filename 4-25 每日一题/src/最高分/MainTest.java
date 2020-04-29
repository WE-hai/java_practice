package 最高分;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0;i < arr.length;i++) {
                arr[i] = scanner.nextInt();
            }
            String[] strs = new String[M];
            for (int i = 0;i < M;i++) {
                String s = scanner.next();
                int max = 0;
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                if (s.equals("Q")) {
                    if (A >= B) {
                        for(int j = B-1; j <= A-1;j++) {
                            if (max > arr[j]) {
                                max = max;
                            } else {
                                max = arr[j];
                            }
                        }
                        System.out.println(max);
                    } else {
                        for(int j = A-1; j <= B-1;j++) {
                            if (max > arr[j]) {
                                max = max;
                            } else {
                                max = arr[j];
                            }
                        }
                        System.out.println(max);
                    }
                } else if (s.equals("U")) {
                    arr[A-1] = B;
                }
            }
        }
    }
}