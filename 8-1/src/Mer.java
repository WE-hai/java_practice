import java.util.Arrays;

public class Mer {
    public static void mergeInternal(int[] arr,int left,int mid,int right,int[] tmp) {
        int begin1 = left,end1 = mid;
        int begin2 = mid+1,end2 = right;
        int index = left;
        while (begin1 <= end1 && begin2 <= end2) {
            if (arr[begin1] <= arr[begin2]) {
                tmp[index++] = arr[begin1++];
            } else {
                tmp[index++] = arr[begin2++];
            }
        }
        while (begin1 <= end1) {
            tmp[index++] = arr[begin1++];
        }
        while (begin2 <= end2) {
            tmp[index++] = arr[begin2++];
        }
        for (int i = left;i <= right;i++) {
            arr[i] = tmp[i];
        }
    }

    public static void merge(int[] arr,int left,int right,int[] tmp) {
        if (left >= right) {
            return;
        }
        int mid = (left+right)/2;
        merge(arr,left,mid,tmp);
        merge(arr,mid+1,right,tmp);
        mergeInternal(arr,left,mid,right,tmp);
    }

    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        merge(arr,0,arr.length-1,tmp);
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,12,9,21,27,17,14,7};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
