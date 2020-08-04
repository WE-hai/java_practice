package 排序.归并排序;

import java.util.Arrays;

public class Solution {
    private static void merge(int[] arr,int low,int mid,int high) {
        int i = low;
        int j = mid;
        int length = high-low;
        int[] extra = new int[length];
        int k = 0;
        //选择小的放入extra
        while (i < mid && j < high) {
            //加入等于，保证稳定性
            if (arr[i] <= arr[j]) {
                extra[k++] = arr[i++];
            } else {
                extra[k++] = arr[j++];
            }
        }
        //将元素放入extra
        while (i < mid) {
            extra[k++] = arr[i++];
        }
        while (j < high) {
            extra[k++] = arr[j++];
        }
        //从extra搬移回arr
        for (int t = 0;t < length;t++) {
            //需要搬移会原位置，从low开始
            arr[low+t] = extra[t];
        }
    }

    private static void mergeInternal(int[] arr,int low,int high) {
        if (low >= high-1) {
            return;
        }
        int mid = (low+high)/2;
        mergeInternal(arr,low,mid);
        mergeInternal(arr,mid,high);
        merge(arr,low,mid,high);
    }

    public static void mergeSort(int[] arr) {
        mergeInternal(arr,0,arr.length);
    }

    public static void mergeSortNoR(int[] arr) {
        for (int i = 1;i < arr.length;i = i*2) {
            for (int j = 0;j < arr.length;j = j+2*i) {
                int low = j;
                int mid = j+i;
                if (mid >= arr.length) {
                    continue;
                }
                int high = mid +1;
                if (high > arr.length) {
                    high = arr.length;
                }
                merge(arr,low,mid,high);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {4,9,2,12,43,23,10,29,7,5,16};
        int[] arr2 = {4,2,6,23,12,31,11,28,17,32};
        System.out.println("原 数 组 arr1："+Arrays.toString(arr1));
        mergeSort(arr1);
        System.out.println("快速排序后数组："+Arrays.toString(arr1));
        System.out.println("原 数 组 arr1："+Arrays.toString(arr2));
        mergeSortNoR(arr2);
        System.out.println("快速排序后数组："+Arrays.toString(arr2));

    }
}
