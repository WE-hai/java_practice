import java.util.Arrays;

public class quickSort {
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
        arr[left] = key;
        return left;
    }

    public static void quickSortPartition(int[] arr,int left,int right) {
        if (left < right) {
            int mid = partition(arr,left,right);
            quickSortPartition(arr,left,mid-1);
            quickSortPartition(arr,mid+1,right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,1,6,9,10,21,8,12,2,18};
        System.out.println(Arrays.toString(arr));
        quickSortPartition(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
