package 数组累乘;

public class Solution {
    public int[] multiply(int[] A) {
        if (A.length == 0) {
            return A;
        }
        int[] B = new int[A.length];
        boolean flag = false;
        for(int i = 0;i < A.length;i++){
            B[i] = 1;
            for(int j = 0;j < A.length;j++){
                int tmp = 1;
                if(j == i) {
                    flag = true;
                    tmp = A[j];
                    A[j] = 1;
                }
                B[i] *= A[j];
                if(flag){
                    A[j] =tmp;
                    flag = false;
                }
            }
        }
        return B;
    }
}
