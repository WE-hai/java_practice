import java.util.Stack;

public class Main {
    public int partition(int[] arr,int left,int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }
    public void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            int mid = partition(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }
    public void quickSortNoR(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        Stack<Integer> st = new Stack<>();
        if (left < right) {
            st.push(left);
            st.push(right);
        }
        while (!st.isEmpty()) {
            int right1 = st.pop();
            int left1 = st.pop();
            int mid = partition(arr,left1,right1);
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

    //
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
    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        merge(arr,0,arr.length-1,tmp);
    }

    public static void mergeSortNoR(int[] arr) {
        int[] tmp = new int[arr.length];
        for (int i = 1;i < arr.length;i *= 2) {
            for (int j = 0;j < arr.length;j += 2*i) {
                int left = j;
                int mid = j+i-1;
                if (mid >= arr.length-1) {
                    continue;
                }
                int right = j+2*i-1;
                if (right >= arr.length) {
                    right = arr.length-1;
                }
                mergeInternal(arr,left,mid,right,tmp);
            }
        }
    }

}
