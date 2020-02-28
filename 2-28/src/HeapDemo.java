import java.util.Arrays;

public class HeapDemo {
    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void shiftDownBig(int[] arr,int sz,int parent) {
        //左孩子
        int child = 2*parent+1;
        while (child < sz) {
            //右孩子
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

    public static void shiftDownSmall(int[] arr,int sz,int parent) {
        int child = 2*parent+1;
        while (child < sz) {
            if (child+1 < sz && arr[child+1] < arr[child]) {
                child++;
            }
            if (arr[child] < arr[parent]) {
                swap(arr,child,parent);
                parent = child;
                child = 2*parent+1;
            } else {
                break;
            }
        }
    }

    public static void createHeapBig(int[] arr) {
        for (int i = (arr.length-2)/2;i >=0;i--) {
            shiftDownBig(arr,arr.length,i);
        }
    }

    public static void createHeapSmall(int[] arr) {
        for (int i = (arr.length-2)/2;i >= 0;i--) {
            shiftDownSmall(arr,arr.length,i);
        }
    }

    public static void shiftUpBig(int[] arr,int sz,int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if (arr[child] > arr[parent]) {
                swap(arr,child,parent);
                child = parent;
                parent = (child-1)/2;
            } else {
                break;
            }
        }
    }

    public static void shiftUpSmall(int[] arr,int sz,int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if (arr[child] < arr[parent]) {
                swap(arr,child,parent);
                child = parent;
                parent = (child-1)/2;
            } else {
                break;
            }
        }
    }

    public static void createHeapUpBig(int[] arr) {
        for (int i = (arr.length-2)/2;i >= 0;i--) {
            shiftUpBig(arr,arr.length,i);
        }
    }

    public static void createHeapUpSmall(int[] arr) {
        for (int i = (arr.length-2)/2;i >= 0;i--) {
            shiftUpSmall(arr,arr.length,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,4,5,23,6,9,12,43,17,2,1,7};
        int[] copy = arr.clone();
        System.out.println(Arrays.toString(arr));
        createHeapBig(arr);
        System.out.println(Arrays.toString(arr));
        createHeapSmall(copy);
        System.out.println(Arrays.toString(copy));
        System.out.println();
        createHeapUpSmall(copy);
        System.out.println(Arrays.toString(copy));
        createHeapUpBig(arr);
        System.out.println(Arrays.toString(arr));
    }
}
