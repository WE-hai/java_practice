package 腐烂的橘子;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangeRotting(int[][] grid) {
        //用Entry存放位置
        Queue<Pair> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        //已经腐烂的位置入队
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i,j));
                }
            }
        }
        //可以蔓延的地方
        int[][] nextP = {{0,1},{1,0},{0,-1},{-1,0}};
        int step = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            int flag = 0;
            //用当前这一批已经腐烂的橘子带出下一批要腐烂的橘子
            //故要遍历队列中的所有位置
            while (n-- != 0) {
                Pair curPos = q.peek();
                q.poll();
                //当前位置像四个方向蔓延
                for (int i = 0;i < 4;i++) {
                    int nx = curPos.x+nextP[i][0];
                    int ny = curPos.y+nextP[i][1];
                    //如果位置越界或者是空格，或者已经是腐烂的位置，则跳过
                    if (nx >= row || nx < 0 || ny >= col || ny < 0 || grid[nx][ny] != 1) {
                        continue;
                    }
                    //标记有新的被腐烂
                    flag = 1;
                    grid[nx][ny] = 2;
                    q.offer(new Pair(nx,ny));
                }
            }
            //如果有新腐烂，才++
            if (flag == 1) {
                step++;
            }
        }
        //判断是否还有无法腐烂的
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return step;
    }
}
