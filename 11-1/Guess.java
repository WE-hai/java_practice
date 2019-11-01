import java.util.Scanner;
import java.util.Random;

public class Guess {
	public static int selectDifficult() {
		System.out.println("1. 简单");
		System.out.println("2. 中等");
		System.out.println("3. 地狱");
		Scanner scanner = new Scanner(System.in);
		int difficult = scanner.nextInt();
		scanner.nextLine();
		return difficult;
	}
	
	public static int getRandom(int difficult) {
		Random random = new Random();
		switch (difficult) {
			case 1: return random.nextInt(50);
			case 2: return random.nextInt(100);
			case 3: return random.nextInt(150);
		}
		return -1;
	}
	
	public static int getTimes(int difficult) {
		Random random = new Random();
		switch (difficult) {
			case 1: return 10;
			case 2: return 5;
			case 3: return 3;
		}
		return -1;
	}
	
	public static boolean guess(int r) {
		System.out.println("请输入数字:");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		if (n == r) {
			return true;
		} else if (n < r) {
			System.out.println("猜小了");
		} else {
			System.out.println("猜大了");
		}
		
		return false;
	}
	public static void main(String[] args) {
	int difficult = selectDifficult();
	int r = getRandom(difficult);
	int times = getTimes(difficult);
	boolean s = false;
	for (int i = 0; i < times; i++) {
			s = guess(r);
			if (s) {
				break;
			}
		}
		if (s) {
			System.out.println("恭喜你，猜对了！");
		} else {
			System.out.println("很遗憾，没有猜到！");
		}
	
	}
}