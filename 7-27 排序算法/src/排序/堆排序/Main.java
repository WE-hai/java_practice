package 排序.堆排序;

import java.util.Arrays;

import static 排序.OtherMethod.swap;

public class Main {
    /*
     堆排序：
     时间复杂度： 建堆： O(n)   log(n) +log(n - 1) + log(n - 2) + ... + 1   ---> n * log(n)
     稳定性： 不稳定  ---> 向下调整可能会破坏相对位置
     空间复杂度：  常数空间  ---> O(1)
   */
    //向下调整大堆
    public static void shiftDownBig(int[] arr,int parent,int size) {
        int child = 2*parent+1;
        while (child < size) {
            //两个孩子节点中选择一个最小的
            if (child+1 < size && arr[child+1] > arr[child]) {
                child++;
            }
            //比较父节点和子节点
            if (arr[child] > arr[parent]) {
                swap(arr,child,parent);
                parent = child;
                child = 2*parent+1;
            } else {
                break;
            }
        }
    }

    //堆排序
    public static void heapSort(int[] arr) {
        int len = arr.length;
        //建堆，最后一个非叶子节点开始向下调整
        for (int i = (len-2)/2;i >= 0;i--) {
            shiftDownBig(arr,i,len);
        }
        //交换 向下调整
        int end = len-1;
        while (end > 0) {
            swap(arr,0,end);
            shiftDownBig(arr,0,end);
            end--;
        }
    }


    public static void shiftDown(int[] arr,int size,int index) {
        int left = 2*index+1;
        while (left < size) {
            int max = left;
            int right = 2*index+2;
            if (right < size) {
                if (arr[right] > arr[left]) {
                    max = right;
                }
            }
            if (arr[index] >= arr[max]) {
                break;
            }
//            int t = arr[index];
//            arr[index] = arr[max];
//            arr[max] = t;
            swap(arr,index,max);
            index = max;
            left = 2*index+1;
        }
    }

    public static void createHeap(int[] arr) {
        for (int i = (arr.length-1)/2;i >= 0;i++) {
            shiftDown(arr,arr.length,i);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4,9,2,12,43,23,10,29,7,5,16};
        int[] arr2 = {3,9,23,10,2,12,43,5,16,29,7};
        System.out.println("原 数 组 arr1："+Arrays.toString(arr1));
        heapSort(arr1);
        System.out.println("堆排序后数组："+Arrays.toString(arr1));
//        System.out.println("原 数 组 arr2："+Arrays.toString(arr2));
//        createHeap(arr2);
//        System.out.println("选择排序后数组："+Arrays.toString(arr2));
    }
}
