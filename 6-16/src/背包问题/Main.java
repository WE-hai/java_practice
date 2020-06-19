package 背包问题;

public class Main {
    public int bag(int m,int[] A,int[] V) {
        int num = A.length;
        if (m == 0 || num == 0) {
            return 0;
        }
        //对加一行一列，用于设置初始条件
        int[][] maxValue = new int[num+1][m+1];
        //初始化所有位置为0，第一行和第一列都为0，初始条件
        for (int i = 0;i <= num;i++) {
            maxValue[i][0] = 0;
        }
        for (int i = 1;i <= m;i++) {
            maxValue[0][i] = 0;
        }
        for (int i = 1;i <= num;i++) {
            for (int j = 1;j <= m;j++) {
                //第i个商品在A中对应的索引为i-1：i从1开始
                //如果第i个商品大于j，说明放不下，所以（i，j）的最大价值和（i-1，j）相同
                if (A[i-1] > j) {
                    maxValue[i][j] = maxValue[i-1][j];
                } else {
                    //如果可以装下，分两种情况，装或不装
                    //如果不装，则即为（i-1，j）
                    //如果装，需要腾出放第i个物品大小的空间：j-A[i-1]，装入之后的最大价值即为(i-1,j-A[i-1]+第i个商品的价值V[i-1]
                    int newValue = maxValue[i-1][j-A[i-1]] + V[i-1];
                    maxValue[i][j] = Math.max(newValue,maxValue[i-1][j]);
                }
            }
        }
        //返回装入前N个商品，物品大小为m的最大价值
        return maxValue[num][m];
    }

    //优化算法
    public int backPack(int m,int[] A,int[] V) {
        int num = A.length;
        if (m == 0 || num == 0) {
            return 0;
        }
        //多加一列，用于设置初始条件，因为第一件商品要用到前面的初始值
        int[] maxValue = new int[m+1];
        //初始化所有位置为0，第一行都为0，初始条件
        for (int i = 0;i <= m;i++) {
            maxValue[i] = 0;
        }
        for (int i = 1;i <= num;i++) {
            for (int j = m;j > 0;j++) {
                //如果第i个商品大于j，说民装不下，分两种情况，装或不装
                //如果不装，则即为(i-1,j)
                //如果装，需要腾出放第i个物品大小的空间：j-A[i],装入之后的最大价值即为(i-1,j-A[i-1)+第i个商品的价值V[i]
                //最后再装与不装中选出最大的价值
                if (A[i-1] <= j) {
                    int newValue = maxValue[j-A[i-1]] + V[i-1];
                    maxValue[j] = Math.max(newValue,maxValue[j]);
                }
            }
        }
        //返回装入前N个商品，物品大小为m的最大价值
        return maxValue[m];
    }
}
