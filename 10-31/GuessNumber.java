import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
	public static void main (String[] args) {
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);
	int n = random.nextInt(200);
	int times = 10;
	for(int i = 1;i <= times;i++) {	
		System.out.print("请输入要猜的数字：");
		int x = scanner.nextInt();
		if(x == n) {
			System.out.println("恭喜你，第"+i+"次机会猜测成功！");
			return;
		} else if(x < n) {
			System.out.println("第"+i+"次机会，猜小了");
		} else {
			System.out.println("第"+i+"次机会，猜大了");
		}
	}
	System.out.println("Game Over");
	System.out.println("数字是："+n);
	}
}