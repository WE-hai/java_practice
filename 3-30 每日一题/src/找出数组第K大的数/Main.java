package 找出数组第K大的数;

import java.util.Arrays;

public class Main {
    public static int findK(int[] arr,int n,int K) {
        Arrays.sort(arr);
        return arr[arr.length-K];
    }

    public static void main(String[] args) {
        int[] arr = {3,6,2,0,9,23,12,5};
        System.out.println(findK(arr,8,2));
    }
}
