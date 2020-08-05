package 排序.希尔排序;

import java.util.Arrays;

public class Main {
     /*
      希尔排序：改进的插入排序，数据越有序，优化的空间就越小
      时间复杂度： O(n) ~ O(n^2)  -----> O(n^1.3)
      稳定性：不稳定
      空间复杂度：  常数空间  ---> O(1)
    */
     public static void shellSort1(int[] arr) {
         int gap = arr.length;
         while (gap > 1) {
             gap = gap/3+1;
             //i 表示已排序数据的最后一个位置
             for (int i = 0;i < arr.length-gap;i++) {
                 int end = i;
                 int key = arr[end+gap];
                 while (end >= 0 && arr[end] > key) {
                     arr[end+gap] = arr[end];
                     end -= gap;
                 }
                 arr[end+gap] = key;
             }
         }
     }

     public static void insertSortGap(int[] arr,int gap) {
         for (int i = 1;i < arr.length;i++) {
             int v = arr[i];
             int j = i-gap;
             for (;j >= 0 && arr[j] > v;j--) {
                 arr[j+gap] = arr[j];
             }
             arr[j+gap] = v;
         }
     }
     public static void shellSort2(int[] arr) {
         int gap = arr.length;
         while (gap > 1) {
             insertSortGap(arr,gap);
             gap = (gap/3)-1;
         }
         insertSortGap(arr,1);
     }

    public static void main(String[] args) {
        int[] arr1 = {4,9,2,12,43,23,10,29,7,5,16};
        int[] arr2 = {3,9,23,10,2,12,43,5,16,29,7};
        System.out.println("原 数 组 arr1："+Arrays.toString(arr1));
        shellSort1(arr1);
        System.out.println("希尔排序后数组："+Arrays.toString(arr1));
        System.out.println("原 数 组 arr2："+Arrays.toString(arr2));
        shellSort2(arr2);
        System.out.println("希尔排序后数组："+Arrays.toString(arr2));

    }


}
