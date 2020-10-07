import java.util.Arrays;

public class Sort {
    public static void mergeInternal(int[] arr, int left, int mid,
                                     int right, int[] tmp){
        int begin1 = left, end1 = mid;
        int begin2 = mid + 1, end2 = right;
        int idx = left;
        while(begin1 <= end1 && begin2 <= end2) {
            if(arr[begin1] <= arr[begin2]) {
                //能否原地合并
                tmp[idx++] = arr[begin1++];
            } else {
                tmp[idx++] = arr[begin2++];
            }
        }
        //判断是否还有剩余元素
        while(begin1 <= end1) {
            tmp[idx++] = arr[begin1++];
        }
        while(begin2 <= end2) {
            tmp[idx++] = arr[begin2++];
        }
        //拷贝
        for(int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

    /*
        归并递归：
        时间复杂度：O(nlogn)
        稳定性：稳定
        空间复杂度：O(n)  需要辅助空间对元素进行归并，不能原地归并
     */
    public static void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if(left >= right) {
            return;
        }
        // 分组 /分解
        int mid = (left + right) / 2;
        // 首先给 [left, mid]   和  [mid + 1, right]小组数据进行排序
        mergeSort(arr, left, mid, tmp);
        mergeSort(arr, mid +1, right, tmp);
        //归并： 前提条件----> 小组数据已经有序
        mergeInternal(arr, left, mid, right, tmp);
    }

    public static void merge(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr,0,arr.length - 1,tmp);
    }

    public static void main(String[] args) {
        int[] a = {3,4,6,2,1,34,12,11,24};
        merge(a);
        System.out.println(Arrays.toString(a));
    }
}
