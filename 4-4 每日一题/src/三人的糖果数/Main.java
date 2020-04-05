package 三人的糖果数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        int n4 = scanner.nextInt();
        int A = (n1+n3)/2;
        int B = (n2+n4)/2;
        int C = B-n2;
        if ((n1+n3)%2 == 0 && (n2+n4)%2 == 0 && A+B == n3) {
            System.out.println(A+" "+B+" "+C);
        } else {
            System.out.println("No");
        }
    }
}
