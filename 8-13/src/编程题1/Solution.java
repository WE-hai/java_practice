import 编程题1.Main;

public class Solution {
	public int daycost (int len, int m, int n) {
		int[] dp = new int[len];
		for (int i = 0;i < len;i++) {
			dp[i] = dp[i-1]+m;
			if (dp[i] > len) {
				dp[i] -= n;
			} else {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Main t = new Main();
		System.out.println(t.daycost(10,4,3));
	}
		
}