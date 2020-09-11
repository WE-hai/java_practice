import java.util.Scanner;

public class Main {
    public static long gcd(long x,long y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(gcd(scanner.nextInt(), scanner.nextInt()));
    }
}
