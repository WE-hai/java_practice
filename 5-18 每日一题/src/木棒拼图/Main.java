package 木棒拼图;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i < n;i++) {
            int flag = scanner.nextInt();
            int len = scanner.nextInt();
            if (flag == 1) {
                list.add(len);
            } else {
                int index = list.indexOf(len);
                list.remove(index);
            }
            if (list.size() < 3) {
                System.out.println("No");
            } else {
                Collections.sort(list,Collections.reverseOrder());
                int max = list.get(0);
                int sum = 0;
                for (int j = 1;j < list.size();j++) {
                    sum += list.get(j);
                }
                if (sum > max) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
