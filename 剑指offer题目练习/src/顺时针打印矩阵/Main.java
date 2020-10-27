package 顺时针打印矩阵;

import java.util.ArrayList;

public class Main {
    // 走的方向：向右、向下、向左、向上
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[][] vis = new boolean[n][m];
        ArrayList<Integer> list = new ArrayList<>();

        int x = 0, y = 0, dir = 0;
        while (x >= 0 && x < n && y >= 0 && y < m && !vis[x][y]) {
            list.add(matrix[x][y]);
            vis[x][y] = true;

            // 试着继续向dir的方向走
            while (x + dx[dir] >= 0 && x + dx[dir] < n && y + dy[dir] >= 0 && y + dy[dir] < m && !vis[x + dx[dir]][y + dy[dir]]) {
                x += dx[dir];
                y += dy[dir];
                list.add(matrix[x][y]);
                vis[x][y] = true;
            }
            // 走不动了换方向
            dir = (dir + 1) % 4;
            x += dx[dir];
            y += dy[dir];
        }
        return list;
    }
}
