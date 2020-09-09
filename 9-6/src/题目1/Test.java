package 题目1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int[] pi = new int[p];
            int[] qi = new int[q];
            Set<Integer> st = new HashSet<>();
            for (int i = 0; i < p; i++) {
                pi[i] = scanner.nextInt();
                st.add(pi[i]);
            }
            for (int i = 0; i < q; i++) {
                qi[i] = scanner.nextInt();
                st.add(qi[i]);
            }
            int tmp = (p+q)-st.size();
            System.out.println((p - tmp) + " " + (q - tmp) + " " + (tmp));
        }
    }
}
