package 题目1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int[] pi = new int[p];
            int[] qi = new int[q];
            for (int i = 0;i < p;i++) {
                pi[i] = scanner.nextInt();
            }
            for (int i = 0;i < q;i++) {
                qi[i] = scanner.nextInt();
            }
            List<Integer> list = new ArrayList<>();
            int a = 0;
            int b = 0;
            int g = 0;
            for (int i = 0;i < p;i++) {
                for (int j = 0;j < q;j++) {
                    if (pi[i] == qi[j]) {
                        list.add(pi[i]);
                    }
                }
            }
            a = pi.length-list.size();
            b = qi.length-list.size();
            g = list.size();
            System.out.print(a+" "+b+" "+g);
        }
    }
}
