package 岛屿数量;

public class Solution {
    int[][] nextPosition = {{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(char[][] grid,int row,int col,int[][] book,int x,int y) {
        //处理当前逻辑
        book[x][y] = 1;
        //遍历每一种可能，四个方向
        for (int k = 0;k < 4;k++) {
            int nx = x+nextPosition[k][0];
            int ny = y+nextPosition[k][1];
            //判断新位置是否越界
            if (nx >= row || nx < 0 || ny >= col || ny < 0) {
                continue;
            }
            //如果符合要求，并且之前也没有渲染过，则继续渲染
            if (grid[nx][ny] == '1' && book[nx][ny] == 0) {
                dfs(grid,row,col,book,nx,ny);
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int ret = 0;
        int row = grid.length;
        int col = grid[0].length;

        int[][] book = new int[row][col];
        //以每一个网格点位渲染起点开始
        for (int i = 0 ;i < row;i++) {
            for (int j = 0;j < col;j++) {
                if (grid[i][j] == '1' && book[i][j] == 0) {
                    ret++;
                    dfs(grid,row,col,book,i,j);
                }
            }
        }
        return ret;
    }
}
