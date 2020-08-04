package 排序.冒泡排序;

import java.util.Arrays;

import static 排序.OtherMethod.swap;

public class Main {
    public static void bubbleSort(int[] arr) {
        //len 未排序的元素个数
        int len = arr.length;
        while (len > 0) {
            //flag = true 表示已经有序
            boolean flag = true;
            //一轮冒泡排序，排好一个元素的位置
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

    public static void bubbleSort2(int[] arr) {
        for (int i = 0;i < arr.length-1;i++) {
            boolean flag = true;
            for (int j = 0;j < arr.length-i-1;i++) {
                //相等不交换
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }

        }

    }

    public static void main(String[] args) {
        int[] arr1 = {4,9,2,12,43,23,10,29,7,5,16};
        int[] arr2 = {3,9,23,10,2,12,43,5,16,29,7};
        System.out.println("原 数 组 arr1："+Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("冒泡排序后数组："+Arrays.toString(arr1));
        System.out.println("原 数 组 arr2："+Arrays.toString(arr2));
        bubbleSort2(arr2);
        System.out.println("冒泡排序后数组："+Arrays.toString(arr2));

    }
}
