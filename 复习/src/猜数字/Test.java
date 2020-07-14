package 猜数字;

import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int toGuess = random.nextInt(100);
        while (true) {
            System.out.print("请输入要猜的数字：");
            int num = scanner.nextInt();
            if (num < toGuess) {
                System.out.println("猜小了！");
            } else if (num > toGuess) {
                System.out.println("猜大了！");
            } else {
                System.out.println("恭喜你，猜对了！");
                break;
            }
        }
        scanner.close();
    }
}
