package 排序.归并排序;

import java.util.Arrays;

public class Main {
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

    /*
        归并递归：
        时间复杂度：O(nlogn)
        稳定性：稳定
        空间复杂度：O(n)  需要辅助空间对元素进行归并，不能原地归并
     */
    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        merge(arr,0,arr.length-1,tmp);
    }
    public static void mergeSortNoR(int[] arr) {
        int[] tmp = new int[arr.length];
        //i 每次归并的元素个数
        for (int i = 1;i < arr.length;i *= 2) {
            //j 下一次归并的起始位置
            for (int j = 0;j < arr.length;j += 2*i) {
                int left = j;
                int mid = j+i-1;
                if (mid >= arr.length-1) {
                    continue;
                }
                int right = j+2*i-1;
                //判断右边的区间是否越界
                if (right >= arr.length) {
                    right = arr.length-1;
                }
                mergeInternal(arr,left,mid,right,tmp);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {4,9,2,12,43,23,10,29,7,5,16};
        int[] arr2 = {3,9,23,10,2,12,43,5,16,29,7};
        System.out.println("原 数 组 arr1："+Arrays.toString(arr1));
        mergeSort(arr1);
        System.out.println("快速排序后数组："+Arrays.toString(arr1));
        System.out.println("原 数 组 arr1："+Arrays.toString(arr2));
        mergeSortNoR(arr2);
        System.out.println("快速排序后数组："+Arrays.toString(arr2));

    }


}
