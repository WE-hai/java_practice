package 排序.插入排序;

import java.util.Arrays;

public class Main {
    /*
      插入排序：
      时间复杂度： 最坏情况： O(n^2) ---> 逆序序列    最好情况：O(n)  ---> 顺序序列
      稳定性：稳定
      空间复杂度：  常数空间  ---> O(1)
    */
    public static void insertSort1(int[] arr) {
        for (int i = 0;i < arr.length-1;i++) {
            int key = arr[i+1];
            //i表示已排序数据的最后一个位置
            int end = i;
            while (end >= 0 && arr[end] > key) {
                //把大的元素向后移动
                arr[end+1] = arr[end];
                //向前搜索
                end--;
            }
            arr[end+1] = key;
        }
    }

    public static void insertSort2(int[] arr) {
        for (int i = 1;i < arr.length;i++) {
            int key = arr[i];
            int j = i-1;
            for (;j >= 0 && arr[j] > key;j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = key;
        }
    }

    public static void bsInsertSort(int[] arr) {
        for (int i = 1;i < arr.length;i++) {
            int v = arr[i];
            int left = 0;
            int right = i;
            while (left < right) {
                int m = (left+right)/2;
                if (v >= arr[m]) {
                    left = m+1;
                } else {
                    right = m;
                }
            }
            //搬移
            for (int j = i;j > left;j--) {
                arr[j] = arr[j-1];
            }
            arr[left] = v;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4,9,2,12,43,23,10,29,7,5,16};
        int[] arr2 = {4,9,23,10,2,12,43,5,16,29,7};
        System.out.println("原 数 组 arr1："+Arrays.toString(arr1));
        insertSort1(arr1);
        System.out.println("插入排序后数组："+Arrays.toString(arr1));
        System.out.println("原 数 组 arr2："+Arrays.toString(arr2));
        insertSort2(arr2);
        System.out.println("插入排序后数组："+Arrays.toString(arr2));
    }
}
