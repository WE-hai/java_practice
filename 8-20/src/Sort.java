import java.util.Stack;

public class Sort {
    public void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int partition1(int[] arr, int left, int right) {
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

    public int partition2(int[] arr, int left, int right) {
        //获取基准值
        int key = arr[left];
        //挖坑填坑
        while (left < right) {
            //从右边找第一个小于key的数据，填左边的坑
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
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

    public int getMid(int[] arr, int left, int right) {
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
    public int partition3(int[] arr,int left,int right) {
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

    /*
   快排递归：
   时间复杂度：O(nlogn)    最坏时间复杂度： 没有优化之前 O(n^2)
   稳定性：不稳定  基准值的位置进行交换的时候有可能改变相同元素的相对位置
   空间复杂度：logn
    */
    public void quickSort(int[] arr,int left,int right) {
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
    public void quickSortNoR(int[] arr) {
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

    /**
     * 归并排序
     */
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
}
