package 整数逆序字符串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            StringBuffer s = new StringBuffer(Integer.toString(n));
            System.out.println(s.reverse());
        }
    }
}
