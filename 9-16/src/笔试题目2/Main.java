package 笔试题目2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String str = s.trim();
            char[] chs = str.toCharArray();
            if ((chs[0] > '9' || chs[0] < '0') && chs[0] != '+' && chs[0] != '-') {
                System.out.println(0);
                return;
            }
            StringBuilder sb = new StringBuilder();
            if ((chs[0] <= '9' && chs[0] >= '0') || chs[0] == '+' || chs[0] == '-') {
                for (int i = 1;i < chs.length;i++) {
                    if (chs[i] >= '0' && chs[i] <= '9') {
                        sb.append(chs[i]);
                    }
                }
            }
            System.out.println(chs[0]+sb.toString());
        }
    }
}
