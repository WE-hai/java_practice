package 携程题目1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String[] strs = new String[k];
            for (int i = 0;i < k;i++) {
                strs[i] = scanner.next();
            }
            int sum = 0;
            for (int i = 0;i < strs.length;i++) {
                String[] ss = strs[i].split(",");
                sum += (Integer.parseInt(ss[ss.length-n]));
            }
            System.out.println(sum);
        }
    }
}
