package 守形数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int fac = n*n;
            String s1 = String.valueOf(n);
            String s2 = String.valueOf(fac);
            String s = s2.substring(s2.length()-s1.length(),s2.length());
            if (s.equals(s1)) {
                System.out.println("Yes!");
            } else {
                System.out.println("No!");
            }
        }
    }
}
