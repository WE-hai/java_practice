package 三角矩阵;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        List<List<Integer>> minPathSum = new ArrayList<>();
        for (int i = 0;i < triangle.size();i++) {
            minPathSum.add(new ArrayList<>());
        }
        //F[0][0]初始化
        minPathSum.get(0).add(triangle.get(0).get(0));
        for (int i = 1;i < triangle.size();i++) {
            int curSum = 0;
            for (int j = 0;j <= i;j++) {
                //处理左边界和有边界
                if (j == 0) {
                    curSum = minPathSum.get(i-1).get(0);
                } else if (j == 1) {
                    curSum = minPathSum.get(i-1).get(j-1);
                } else {
                    curSum = Math.min(minPathSum.get(i-1).get(j),minPathSum.get(i-1).get(j-1));
                }
                // F(i,j) = min( F(i-1, j-1), F(i-1, j)) + triangle[i][j]
                minPathSum.get(i).add(triangle.get(i).get(j) + curSum);
            }
        }
        int size = triangle.size();
        //min(F(n-1,i))
        int allMin = minPathSum.get(size-1).get(0);
        for (int i = 1;i < size;i++) {
            allMin = Math.min(allMin,minPathSum.get(size-1).get(i));
        }
        return allMin;
    }

    //动态规划
    public  int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        //F[n-1][n-1]........F[n-1][0]初始化
        ArrayList<ArrayList<Integer>> minPathSum = new ArrayList<>();
        int row = minPathSum.size();
        //从倒数第二行开始
        for (int i = row-2;i >= 0;i--) {
            for (int j = 0;j <= i;j++) {
                // F(i,j) = min( F(i+1, j), F(i+1, j+1)) + triangle[i][j]
                int curSum = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)) + triangle.get(i).get(j);
                minPathSum.get(i).set(j,curSum);
            }
        }
        return minPathSum.get(0).get(0);

    }
}
