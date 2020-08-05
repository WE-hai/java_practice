package 排序.快速排序;

import static 排序.OtherMethod.swap;

public class Partition {
    //三数取中法：为了让数据分组更加均衡
    public static int getMid(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[mid] > arr[left]) {
            if (arr[mid] < arr[right]) {
                return mid;
            } else {
                if (arr[left] > arr[right]) {
                    return left;
                } else {
                    return right;
                }
            }
        } else {
            if (arr[mid] > arr[right]) {
                return mid;
            } else {
                if (arr[left] < arr[right]) {
                    return left;
                } else {
                    return right;
                }
            }
        }
    }

    public static int partition1(int[] arr, int left, int right) {
        //基准值
        int key = arr[left];
        int start = left;
        while (left < right) {
            //一定要先从后向前找第一个小于 key 的数据位置，否则数据位置会产生错误
            while (left < right && arr[right] >= key) {
                right--;
            }
            //从前向后找第一个大于key的数据位置
            while (left < right && arr[left] <= key) {
                left++;
            }
            swap(arr, left, right);
        }
        //把基准值和相遇的位置的数据进行交换
        swap(arr, left, start);
        return left;
    }

    public static int partition2(int[] arr, int left, int right) {
        //获取基准值
        int key = arr[left];
        //挖坑填坑
        while (left < right) {
            //从右边找第一个小于key的数据，填左边的坑
            while (left < right && arr[right] >= key) {
                right--;
            }
            //从左边找第一个大于key的数据，填右边的坑
            while (left < right && arr[left] <= key) {
                left++;
            }
            //填坑
            arr[right] = arr[left];
        }
        //填基准值到中间相遇的位置
        arr[left] = key;
        return left;
    }

    public static int partition3(int[] arr,int left,int right) {
        //三数取中
        int mid = getMid(arr,left,right);
        swap(arr,left,mid);

        int key = arr[left];
        //最后一个小于key的位置
        int prev = left;
        //下一个小于key的位置
        int cur = left+1;
        while (cur <= right) {
            //如果cur找到下一个小于key的位置，并且prev和cur之间有大于key的值，则交换prev, cur的值
            if (arr[cur] < key && ++prev != cur) {
                swap(arr,prev,cur);
            }
            cur++;
        }
        swap(arr,left,prev);
        return prev;
    }
}
