import java.util.Stack;

public class Sort {
    //交换
    public void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*
    直接插入排序
    时间复杂度：最坏情况： O(n^2) ---> 逆序序列    最好情况：O(n)  ---> 顺序序列
    空间复杂度：O(1)
    稳定性：稳定
     */
    public void insertSort(int[] arr) {
        //开始可以认为第0个位置是排好序
        for (int i = 0;i < arr.length-1;i++) {
            int key = arr[i+1];
            int end = i;
            while (end >= 0 && arr[end] > key) {
                arr[end+1] = arr[end];
                end--;
            }
            arr[end+1] = key;
        }
    }

    /*
    希尔排序
    时间复杂度：O(n) ------> O(n^2)
    空间复杂度：O(1)
    稳定性：不稳定
     */
    public void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap = gap/3+1;
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

    /*
    选择排序
    时间复杂度：O(n^2)
    空间复杂度：O(1)
    稳定性：稳定/不稳定
     */
    public void selectSort(int[] arr) {
        int begin = 0;
        int end = arr.length-1;
        while (begin < end) {
            int min = begin;
            int max = begin;
            for (int i = begin;i <= end;i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
                if (arr[i] >= arr[max]) {
                    max = i;
                }
            }
            swap(arr,begin,min);
            if (max == begin) {
                max = min;
            }
            swap(arr,end,max);
            begin++;
            end--;
        }
    }
    public void selectSort2(int[] arr) {
        for (int i = arr.length-1;i > 0;i--) {
            int end = i;
            int max = i;
            for (int j = end-1;j >= 0;j--) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            swap(arr,max,end);
        }
    }

    /*
    堆排序
    时间复杂度：O(nlogn)
    空间复杂度：O(1)
    稳定性：不稳定
     */
    //向下调整
    public void shiftDown(int[] arr,int sz,int parent) {
        int child = 2*parent+1;
        while (child < sz) {
            if (child+1 < sz && arr[child+1] > arr[child]) {
                child++;
            }
            if (arr[child] > arr[parent]) {
                swap(arr,child,parent);
                parent = child;
                child = 2*parent+1;
            } else {
                break;
            }
        }
    }
    public void heapSort(int[] arr) {
        for (int i = (arr.length-2)/2;i >= 0;i--) {
            shiftDown(arr,arr.length,i);
        }
        int end = arr.length-1;
        while (end > 0) {
            swap(arr,0,end);
            shiftDown(arr,end,0);
            end--;
        }
    }

    /*
    冒泡排序
    时间复杂度：O(n)~ O(n^2)
    空间复杂度：O(1)
    稳定性：稳定
     */
    public void bubbleSort(int[] arr) {
        int len = arr.length;
        while (len > 0) {
            boolean flag = true;
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

    /*
    快速排序
    时间复杂度：O(nlogn)
    空间复杂度：O(logn)
    稳定性：不稳定
     */
    public int partition1(int[] arr, int left, int right){
        //基准值
        int key = arr[left];
        int start = left;
        while(left < right) {
            //一定要先从后向前找第一个小于key的数据位置， 否则数据的位置会产生错误
            while(left < right && arr[right] >= key) {
                right--;
            }
            //从前向后找第一个大于key的数据位置
            while(left < right &&arr[left] <= key) {
                left++;
            }
            //交换
            swap(arr, left, right);
        }
        //把基准值和相遇的位置的数据进行交换
        //错误： arr[left] = key; 相遇位置的数据被覆盖
        swap(arr, left, start);
        return left;
    }
    public int partition2(int[] arr, int left, int right){
        //获取基准值
        int key = arr[left];
        //挖坑填坑
        while(left < right) {
            //从右边找第一个小于key的数据，填左边的坑
            while(left < right && arr[right] >= key) {
                right--;
            }
            //填坑
            arr[left] = arr[right];
            //从左边找第一个大于key的数据，填右边的坑
            while(left < right && arr[left] <= key) {
                left++;
            }
            //填坑
            arr[right] = arr[left];
        }
        //填基准值到中间相遇的位置
        arr[left] = key;
        return left;
    }
    //三数取中法： 为了让数据分组更加均衡
    public int getMid(int[] arr, int left, int right){
        // 从 arr[left], arr[mid], arr[right],中选一个中间值
        int mid = (left + right) / 2;
        if(arr[mid] > arr[left]){
            if(arr[mid] < arr[right]) {
                return mid;
            } else {
                // mid  > left, >= right
                if(arr[left] > arr[right]) {
                    return left;
                } else {
                    return right;
                }
            }
        } else {
            // mid <= left
            if(arr[mid] > arr[right]) {
                return mid;
            } else {
                // mid <= left, <= right
                if(arr[left] < arr[right]) {
                    return left;
                } else {
                    return right;
                }
            }
        }
    }
    public int partition3(int[] arr, int left, int right){
        //三数取中
        int mid = getMid(arr, left, right);
        swap(arr, left, mid);
        int key = arr[left];
        int prev = left;    //最后一个小于key的位置
        int cur = left + 1; //下一个小于key的位置
        while(cur <= right){
            //如果cur找到下一个小于key的位置，并且prev 和 cur之间有大于key的值，则交换prev, cur的值
            if(arr[cur] < key && ++prev != cur) {
                swap(arr, prev, cur);
            }
            cur++;
        }
        swap(arr, left, prev);
        return prev;
    }
    public void quickSort(int[] arr,int left,int right) {
        if(left < right){
            //int mid = partition1(arr, left, right);
            //int mid = partition2(arr, left, right);
            int mid = partition3(arr, left, right);
            //进行分组
            quickSort(arr, left, mid-1);
            quickSort(arr, mid+1, right);
        }
    }

    //非递归快排
    public void quickSortNo(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        //用栈来记录
        Stack<Integer> stack = new Stack<>();
        if (left < right) {
            stack.push(left);
            stack.push(right);
        }
        while (!stack.isEmpty()) {
            //取出栈顶的一对区间值
            int right1 = stack.pop();
            int left1 = stack.pop();
            //分组
            int mid = partition3(arr,left1,right1);
            //新的分组继续压栈
            if (mid-1 > left1) {
                stack.push(left1);
                stack.push(mid-1);
            }
            if (mid+1 < right1) {
                stack.push(mid+1);
                stack.push(right1);
            }
        }
    }

    /*
    归并排序
    时间复杂度：O(nlogn)
    空间复杂度：O(n)
    稳定性：稳定
     */
    //合并
    public void mergeInternal(int[] arr,int left,int mid,int right,int[] tmp) {
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
        //判断是否有剩余元素
        while (begin1 <= end1) {
            tmp[index++] = arr[begin1++];
        }
        while (begin2 <= end2) {
            tmp[index++] = arr[begin2++];
        }
        //拷贝
        for (int i = left;i <= right;i++) {
            arr[i] = tmp[i];
        }
    }
    public void merge(int[] arr,int left,int right,int[] tmp) {
        if (left >= right) {
            return;
        }
        //分组
        int mid = (left+right)/2;
        merge(arr,left,mid,tmp);
        merge(arr,mid+1,right,tmp);
        //归并
        mergeInternal(arr,left,mid,right,tmp);
    }
    public void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        merge(arr,0,arr.length,tmp);
    }

    //非递归
    public void mergeSortNoR(int[] arr) {
        int[] tmp = new int[arr.length];
        for (int i = 1;i < arr.length;i *= 2) {
            for (int j = 0;j < arr.length;j += 2) {
                int left = j;
                int mid = j+i-1;
                //若右半部分没有数据，不用进行归并
                if (mid >= arr.length-1) {
                    continue;
                }
                int right = j+2*i-1;
                //判断右边区间是否越界
                if (right >= arr.length) {
                    right = arr.length-1;
                }
                mergeInternal(arr,left,mid,right,tmp);
            }

        }
    }
}
