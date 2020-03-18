import java.util.Arrays;

public class MyHeap {
    public void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //大堆的向下调整
    public void shiftDownBig(int[] arr,int sz,int parent) {
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

    //小堆的向下调整
    public void shiftDownSmall(int[] arr,int sz,int parent) {
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

    //建堆
    public void createHeapBig(int[] arr) {
        for (int i = (arr.length-2)/2;i >= 0;i--) {
            shiftDownBig(arr,arr.length,i);
        }
    }

    public void createHeapSmall(int[] arr) {
        for (int i = (arr.length-2)/2;i >= 0;i--) {
            shiftDownSmall(arr,arr.length,i);
        }
    }

    //大堆的向上调整
    public void shiftUpBig(int[] arr,int sz,int child) {
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

    //小堆的向上调整
    public void shiftUpSmall(int[] arr,int sz,int child) {
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

    //建堆
    public void createHeapUpBig(int[] arr) {
        for (int i = (arr.length - 2)/2;i >= 0;i--) {
            shiftUpBig(arr,arr.length,i);
        }
    }

    public void createHeapUpSmall(int[] arr) {
        for (int i = (arr.length - 2)/2;i >= 0;i--) {
            shiftUpSmall(arr,arr.length,i);
        }
    }

    public static void main(String[] args) {
        MyHeap heap = new MyHeap();
        int[] arr = {9,3,10,15,4,2,7,23,43};
        int[] copy = arr.clone();
        System.out.println(Arrays.toString(arr));
        heap.createHeapBig(arr);
        System.out.println(Arrays.toString(arr));
        heap.createHeapSmall(copy);
        System.out.println(Arrays.toString(copy));
        System.out.println();
        heap.createHeapUpSmall(copy);
        System.out.println(Arrays.toString(copy));
        heap.createHeapUpBig(arr);
        System.out.println(Arrays.toString(arr));
    }
}
