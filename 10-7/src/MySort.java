import java.util.Arrays;

public class MySort {
    public static int partition(int[] arr,int left,int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        //填基准值到中间相遇的位置
        arr[left] = key;
        return left;
    }

    public static void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            int mid = partition(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,7,12,4,29,13,1,0,8};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
