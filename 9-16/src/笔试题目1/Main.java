package 笔试题目1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
           String str = s.trim();
            StringBuilder sb = new StringBuilder();
            if (str.charAt(0) < '0' || str.charAt(0) > '9' || (str.charAt(0) != '+' || str.charAt(0) != '-')) {
                System.out.println(0);
            }
            if (str.charAt(0) == '+' || str.charAt(0) == '-' || (str.charAt(0) > '0' && str.charAt(0) <= '9')) {
                for (int i = 1;i < str.length();i++) {
                    if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                        sb.append(str.charAt(i));
                        if (str.charAt(i) < '0' && str.charAt(i) > '9') {
                            break;
                        }
                    }
                }
                if (Integer.parseInt(sb.toString()) > Integer.MAX_VALUE) {
                    System.out.println("INT_MAX (2^31 − 1)");
                } else if (Integer.parseInt(sb.toString()) < Integer.MIN_VALUE){
                    System.out.println("INT_MIN (−2^31)");
                } else {
                    System.out.println(Integer.parseInt(str.charAt(0) + sb.toString()));
                }
            }

        }
    }
}
