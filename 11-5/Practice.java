import java.util.Scanner;

public class Practice {
	public static int fac(int n) {
		if(n == 1) {
			return n;
		} else {
			return n*fac(n-1);
		}
	}
	public static void main(String[] srgs) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个数：");
		int n = scanner.nextInt();
		int ret = fac(n);
		System.out.println(""+n+"!="+ret);
	}
}