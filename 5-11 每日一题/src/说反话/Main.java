package 说反话;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            for (int i = split.length-1;i >= 0;i--) {
                System.out.print(split[i]+" ");
            }
        }
    }
}
