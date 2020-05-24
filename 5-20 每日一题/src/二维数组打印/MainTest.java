package 二维数组打印;

public class MainTest {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        //   if(n<1) return -1;
        //打印上三角包括中间00-nn的对角线
        int [] ret = new int[n*n];
        int index = 0;
        for(int i = n-1;i >= 0;i--){
            int k = i;
            for(int j = 0;j < n-i;j++){
                ret[index++] = arr[j][k++];
            }
        }
        //打印剩下的下三角
        for(int i = 1;i < n;i++){
            int k = i;
            for(int j = 0;j < n-i;j++){
                ret[index++] = arr[k++][j];
            }
        }
        return ret;
    }
}
