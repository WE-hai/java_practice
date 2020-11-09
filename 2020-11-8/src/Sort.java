public class Sort {
    public void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    /*
    * 冒泡排序
    * 时间复杂度：O(n)~O(n^2)  平均：O(n^2)
    * 稳定性：稳定
    * 空间复杂度：O(1)
    */
    public void bubbleSort1(int[] arr) {
        for (int i = 1;i < arr.length;i++) {
            for (int j = 0;j < arr.length-i;j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void bubbleSort2(int[] arr) {
        int len = arr.length;
        while (len > 0) {
            boolean flag = true;
            for (int i = 0;i < len-1;i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr,i,i+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            len--;
        }
    }
    /*
    * 快速排序
    * 时间复杂度：O(nlogn)  最坏：O(n^2)
    * 稳定性：不稳定
    * 空间复杂度：logn
    */
    public static int partion(int[] arr, int left, int right){
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
    public void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            int mid = partion(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }

    /*
    归并排序
    * 时间复杂度：
    * 稳定性：
    * 空间复杂度：
    */
    public void mergeInternal(int[] arr,int left,int mid,int right,int[] tmp) {
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
        for (int i = 0;i <= right;i++) {
            arr[i] = tmp[i];
        }
    }
    public void mergeSort(int[] arr,int left,int right,int[] tmp) {
        if (left >= right) {
            return;
        }
        int mid = (left+right)/2;
        mergeSort(arr,left,mid,tmp);
        mergeSort(arr,mid+1,right,tmp);
        mergeInternal(arr,left,mid,right,tmp);
    }
    public void merge(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);
    }
}
