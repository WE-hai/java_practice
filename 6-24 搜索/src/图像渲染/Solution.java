package 图像渲染;

public class Solution {
    //四个方向的位置更新：顺时针更新
    int[][] nextPosition = {{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(int[][] image,int row,int col,int[][] book,int sr,int sc,int oldColor,int newColor) {
        //处理当前逻辑，修改颜色，并且标记已经修改过的
        image[sr][sc] = newColor;
        book[sr][sc] = 1;

        //遍历每一种可能，四个方向
        for (int i = 0;i < 4;i++) {
            int newSr = sr+nextPosition[i][0];
            int newSc = sc+nextPosition[i][1];
            //判断位置是否越界
            if (newSr >= row || newSr < 0 || newSc >= col || newSc < 0) {
                continue;
            }
            //如果颜色符合要求并且之前也没有染色，则继续渲染
            if (image[newSr][newSc] == oldColor && book[newSr][newSc] == 0) {
                dfs(image,row,col,book,newSr,newSc,oldColor,newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image,int sr,int sc,int newColor) {
        int oldColor = image[sr][sc];
        int row = image.length;
        int col = image[0].length;
        //建立标记
        int[][] book = new int[row][col];
        dfs(image,row,col,book,sr,sc,oldColor,newColor);
        return image;
    }
}
