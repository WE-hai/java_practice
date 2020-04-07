package 放蛋糕;

import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int col = in.nextInt();
        int row = in.nextInt();
        int[][] grid = new int[row][col];
        for(int i = 0; i < row; i++){
            if(i % 4 == 0 || i % 4 == 1){
                for(int j = 0; j < col; j++){
                    if(j % 4 == 0 || j % 4 == 1){
                        grid[i][j] = 1;
                    }
                }
            } else {
                for(int j = 0; j < col; j++){
                    if(j % 4 == 2 || j % 4 == 3){
                        grid[i][j] = 1;
                    }
                }
            }
        }

        int count = 0;
        for(int x = 0; x < row; x++){
            for(int y = 0; y < col; y++){
                if(grid[x][y] == 1){
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}