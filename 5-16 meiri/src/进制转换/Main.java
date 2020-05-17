package 进制转换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(Integer.decode(s));
            System.out.println(Integer.parseInt(s.substring(2),16));
        }
    }
}
