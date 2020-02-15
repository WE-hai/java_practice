import java.util.Arrays;

public class ArrayOuji {
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int n = 0;
        for(int i = 0;i < A.length;i++) {
            if(A[i]%2 == 0) {
                B[n++] = A[i];
            }
        }
        for(int j = 0;j < A.length;j++) {
            if(A[j]%2 == 1) {
                B[n++] = A[j];
            }
        }
        return B;
    }

    public static void main(String[] args) {
        ArrayOuji test = new ArrayOuji();
        int[] arr = {1,3,5,6,4,8,9,2};
        System.out.println(Arrays.toString(test.sortArrayByParity(arr)));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(test.sortArrayByParity(arr)));
    }
}
