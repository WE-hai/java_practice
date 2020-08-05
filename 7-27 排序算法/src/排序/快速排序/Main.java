package 排序.快速排序;

import java.util.Arrays;
import java.util.Stack;

import static 排序.快速排序.Partition.partition1;
import static 排序.快速排序.Partition.partition2;
import static 排序.快速排序.Partition.partition3;

public class Main {
    /*
    快排递归：
    时间复杂度：O(nlogn)    最坏时间复杂度： 没有优化之前 O(n^2)
    稳定性：不稳定  基准值的位置进行交换的时候有可能改变相同元素的相对位置
    空间复杂度：logn
     */
    public static void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            //int mid = partition1(arr,left,right);
            int mid = partition2(arr,left,right);
            //int mid = partition3(arr, left, right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }
   /*
   非递归： 模拟递归过程
   1. 选基准值
   2. 根据基准值分组
   3. 给划分的小组数据进行重复1,2的过程
   */
    public static void quickSortNoR(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        //用栈来记录区间
        Stack<Integer> st = new Stack<>();
        if (left < right) {
            st.push(left);
            st.push(right);
        }
        while (!st.isEmpty()) {
            //取出栈顶的一对区间值
            int right1 = st.pop();
            int left1 = st.pop();
            //分组
            int mid = partition1(arr,left1,right1);
            //新的分组继续压栈
            if (mid-1 > left1) {
                st.push(left1);
                st.push(mid-1);
            }
            if (mid+1 < right1) {
                st.push(mid+1);
                st.push(right1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4,9,2,12,43,23,10,29,7,5,16};
        int[] arr2 = {3,9,23,10,2,12,43,5,16,29,7};
        System.out.println("原 数 组 arr1："+Arrays.toString(arr1));
        quickSort(arr1,0, arr1.length-1);
        System.out.println("快速排序后数组："+Arrays.toString(arr1));
        System.out.println("原 数 组 arr1："+Arrays.toString(arr2));
        quickSortNoR(arr2);
        System.out.println("快速排序后数组："+Arrays.toString(arr2));
    }
}
