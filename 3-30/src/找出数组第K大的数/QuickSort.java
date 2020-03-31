package 找出数组第K大的数;

import java.util.Stack;

public class QuickSort {
    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static int partition(int[] arr, int left, int right){
        int key = arr[left];
        int start = left;
        while(left < right){
            while(left < right && arr[right] >= key) {
                --right;
            }
            while(left < right &&arr[left] <= key) {
                ++left;
            }
            swap(arr, left, right);
        }
        swap(arr, left, start);
        return left;
    }
    public static void quickSortNoR(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        Stack<Integer> st = new Stack<>();
        if(left < right){
            st.push(left);
            st.push(right);
        }
        while(!st.isEmpty()) {
            int right1 = st.pop();
            int left1 = st.pop();
            int mid = partition(arr, left1, right1);
            if(mid - 1 > left1) {
                st.push(left1);
                st.push(mid - 1);
            }
            if(mid + 1 < right1) {
                st.push(mid + 1);
                st.push(right1);
            }
        }
    }

    public static int findK(int[] arr,int n,int K) {
        quickSortNoR(arr);
        return arr[arr.length-K];
    }

    public static void main(String[] args) {
        int[] arr = {2,5,8,12,9,4,23,6};
        System.out.println(findK(arr,8,2));
    }
}
