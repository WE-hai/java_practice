package 顺时针打印矩阵;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        int rowsLength=matrix.length;
        int columnsLength=matrix[0].length;
        int start=0;
        if (matrix==null||columnsLength<=0||rowsLength<=0){
            return null;
        }
        while(columnsLength>start*2&&rowsLength>start*2){
            PrintMatrixInCircle(matrix,result,rowsLength,columnsLength,start);
            start++;
        }
        return result;
    }
    public void PrintMatrixInCircle(int [][] matrix,ArrayList<Integer> input,int row,int column,int start){
        int endx=column-start-1;
        int endy=row-start-1;
        for (int i=start;i<=endx;i++){
            input.add(matrix[start][i]);
        }
        if (start<endy){
            for (int i=start+1;i<=endy;i++){
                input.add(matrix[i][endx]);
            }
        }
        if (start<endx&&start<endy){
            for (int i=endx-1;i>=start;i--){
                input.add(matrix[endy][i]);
            }
        }
        if (start<endx&&start<endy-1){
            for (int i=endy-1;i>start;i--){
                input.add(matrix[i][start]);
            }
        }
    }
}