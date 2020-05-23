package 二维数组打印;

public class Test {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] A = new int[n*n];
        int p = 0;
        for(int p1=n-1;p1>-1;p1--){
            for(int p2=0;p2<n-p1;p2++){
                A[p] = arr[p2][p1+p2];
                A[n*n-1-p] = arr[n-1-p2][n-1-p1-p2];
                p++;
            }
        }
        return A;
    }
}
