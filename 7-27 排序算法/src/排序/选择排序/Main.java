package 排序.选择排序;

import java.util.Arrays;

import static 排序.OtherMethod.swap;

public class Main {
     /*
      选择排序：
      时间复杂度： O(n^2)
      稳定性：可以让它稳定/不稳定
      空间复杂度：  常数空间  ---> O(1)
    */
     public static void selectSort1(int[] arr) {
         int begin = 0;
         int end = arr.length-1;
         while (begin < end) {
             int minIndex = begin;
             int maxIndex = begin;
             for (int i = begin;i <= end;i++) {
                 //最小值在前面
                 if (arr[i] < arr[minIndex]) {
                     minIndex = i;
                 }
                 //最大值选在后面
                 if (arr[i] < arr[maxIndex]) {
                     maxIndex = i;
                 }
             }
             swap(arr,begin,minIndex);
             //如果最大值在起始位置，则经过上面的交换之后，最大值被移动到minIdx指向的位置
             if (maxIndex == begin) {
                 maxIndex = minIndex;
             }
             swap(arr,end,maxIndex);
             begin++;
             end--;
         }
     }

     public static void selectSort2(int[] arr) {
         //i 未排序的最大位置
         for (int i = arr.length-1;i > 0;i--) {
             int end = i;
             int maxIndex = i;
             for (int j = end-1;j >= 0;j--) {
                 if (arr[j] > arr[maxIndex]) {
                     maxIndex = j;
                 }
             }
             swap(arr,maxIndex,end);
         }
     }

     public static void selectSort3(int[] arr) {
         for (int i = 0;i < arr.length-1;i++) {
             int max = 0;
             for (int j = 1;j < arr.length-i;j++) {
                 if (arr[j] > arr[max]) {
                     max = j;
                 }
             }
//             int t = arr[max];
//             arr[max] = arr[arr.length-i-1];
//             arr[arr.length-i-1] = t;
             swap(arr,max,arr.length-i-1);
         }
     }

    public static void main(String[] args) {
        int[] arr1 = {4,9,2,12,43,23,10,29,7,5,16};
        int[] arr2 = {3,9,23,10,2,12,43,5,16,29,7};
        int[] arr3 = {15,9,52,23,10,12,16,29,43,5,7,33};
        System.out.println("原 数 组 arr1："+Arrays.toString(arr1));
        selectSort1(arr1);
        System.out.println("选择排序后数组："+Arrays.toString(arr1));
        System.out.println("原 数 组 arr2："+Arrays.toString(arr2));
        selectSort2(arr2);
        System.out.println("选择排序后数组："+Arrays.toString(arr2));
        System.out.println("原 数 组 arr3："+Arrays.toString(arr3));
        selectSort3(arr3);
        System.out.println("选择排序后数组："+Arrays.toString(arr3));
    }
}
