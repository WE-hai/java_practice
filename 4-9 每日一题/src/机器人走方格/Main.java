package 机器人走方格;

public class Main {
    public static int countWays(int x,int y) {
        if (x+y > 12) {
            return -1;
        }
        int[][] dp = new int[x][y];
        dp[0][0] = 1;
        for(int i = 1; i < x; i++){
            dp[i][0] = dp[i-1][0];
        }
        for(int i = 1; i < y; i++){
            dp[0][i] = dp[0][i-1];
        }
        for(int i = 1; i < x; i++){
            for(int j = 1; j < y; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[x-1][y-1];
    }
    public static void main(String[] args) {
         System.out.println(countWays(2,2));
    }
}
