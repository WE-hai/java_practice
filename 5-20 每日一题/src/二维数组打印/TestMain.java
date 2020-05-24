package 二维数组打印;

public class TestMain {
    public int[] arrayPrint(int[][] arr, int n) {
        int [] aa=new int[arr.length*(arr[0].length)];
        int cout=0;
        for(int i=0;i<arr.length+arr[0].length-1;i++){
            for(int j=0;j<arr.length;j++){
                int x=j+arr[0].length-1-i;
                if(0<=x&&x<=arr[0].length-1){
                    aa[cout]=arr[j][x];
                    cout++;
                }
            }
        }
        return aa;
    }
}
