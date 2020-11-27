package 数组中的逆序对;

public class Main {
    public int count(int[] A,int n) {
        int sum = 0;
        for(int i = 0;i < n;i++) {
            for(int j = i+1;j < n;j++) {
                if (A[i] > A[j]) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
