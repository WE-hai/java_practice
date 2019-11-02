import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
	public static void menu() {
		System.out.println("*************************");
		System.out.println("*****  1、进入游戏  *****");
		System.out.println("*****  0、退出游戏  *****");
		System.out.println("*************************");
	}
	
	public static int selectDifficult() {
		System.out.println("*** 1、简单 ***");
		System.out.println("*** 2、中等 ***");
		System.out.println("*** 3、困难 ***");
		Scanner scanner = new Scanner(System.in);
		int difficult = scanner.nextInt();
		//scanner.nextLine();
		return difficult;
	}
	
	public static int getRandom(int difficult) {
		Random random = new Random();
		switch(difficult) {
			case 1:
				return random.nextInt(50);
			case 2:
				return random.nextInt(100);
			case 3:
				return random.nextInt(200);
		}
		return -1;
	}
	
	public static int getTimes(int difficult) {
		switch(difficult) {
			case 1:
				return 6;
			case 2:
				return 10;
			case 3:
				return 12;
		}
		return -1;
	}
	
	public static boolean guess(int rand) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入数字：");
			int n = scanner.nextInt();
			if(rand > n) {
				System.out.println("猜小了！");
			} else if(rand < n) {
				System.out.println("猜大了！");
			} else {
				return true;
			}
			return false;
	}
	
	public static void game() {
		int difficult = selectDifficult();
		int rand = getRandom(difficult);
		int times = getTimes(difficult);
		boolean g = false;
		for (int i = 1; i <= times; i++) {
			g = guess(rand);
			if (g) {
				break;
			}
		}
		if (g) {
			System.out.println("恭喜你，猜对了！");
		} else {
			System.out.println("很遗憾，没有猜到！");
			System.out.println("数字是："+rand);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean ret = true;
		do {
			menu();
			System.out.print("请选择：");
			int input = scanner.nextInt();
			switch(input) {
				case 1:
					game();
					break;
				case 0:
					System.out.println("退出游戏！");
					ret = false;
				default:
					break;
			}
		}while(ret);
	}
}