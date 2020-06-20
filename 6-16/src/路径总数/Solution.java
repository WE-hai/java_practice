package 路径总数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> pathNum = new ArrayList<>();
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //申请F(i,j)空间，初始化
        //初始化第0列
        for (int i = 0;i < m;i++) {
            pathNum.add(new ArrayList<>());
            //如果当前位置有障碍，则无法表达
            if (obstacleGrid[i][0] == 1) {
                pathNum.get(i).add(0);
            } else {
                //如果当前位置无障碍，但是前面如果到达不了，当前位置也达到不了
                if (i > 0) {
                    if (pathNum.get(i-1).get(0) == 1) {
                        pathNum.get(i).add(1);
                    } else {
                        pathNum.get(i).add(0);
                    }
                } else {
                    pathNum.get(i).add(1);
                }
            }
        }
        //初始化第一行
        for (int i = 1;i < n;i++) {
            if (obstacleGrid[0][i] == 1) {
                pathNum.get(0).add(0);
            } else {
                if (pathNum.get(0).get(i-1) == 1) {
                    pathNum.get(0).add(1);
                } else {
                    pathNum.get(0).add(0);
                }
            }
        }
        for (int i = 1;i < m;i++) {
            for (int j = 1;j < n;j++) {
                // obstacleGrid[i][j] = 1 时，F(i,j)无法到达
                if (obstacleGrid[i][j] == 1) {
                    pathNum.get(i).add(0);
                } else {
                    // F(i,j) = F(i-1,j) + F(i,j-1)
                    pathNum.get(i).add(pathNum.get(i).get(j-1) + pathNum.get(i-1).get(j));
                }
            }
        }
        return pathNum.get(m-1).get(n-1);
    }
}
