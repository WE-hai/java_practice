import java.util.Arrays;

public class MyPriorityQueue {
    int[] arr = new int[10];
    int size;

    //交换
    public static void swap(int[] arr,int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //向上调整
    public static void shiftUp(int[] arr,int sz,int child) {
        int parent = (child - 1)/2;
        while (child > 0) {
            if (arr[child] < arr[parent]) {
                swap(arr, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    //向下调整
    public static void shiftDown(int[] arr,int sz,int parent) {
        int child = 2 * parent + 1;
        while (child < sz) {
            if (child + 1 < sz && arr[child + 1] < arr[child]) {
                child++;
            }
            if (arr[child] < arr[parent]) {
                swap(arr,child,parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public void offer(int value) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr,arr.length*2);
        }
        arr[size++] = value;    //尾插
        shiftUp(arr,size,size-1);   //向上调整
    }

    public int poll() {
        if (size > 0) {
            int peek = arr[0];
            swap(arr,0,size-1);
            size--;
            shiftDown(arr,size,0);
            return peek;
        }
        return -1;
    }

    public int peek() {
        return arr[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue mpq = new MyPriorityQueue();
        mpq.offer(9);
        mpq.offer(2);
        mpq.offer(10);
        mpq.offer(15);
        mpq.offer(3);
        mpq.offer(1);
        mpq.offer(7);
        mpq.offer(22);
        mpq.offer(32);
        while(!mpq.isEmpty()){
            System.out.print(mpq.poll() + " ");
        }
    }
}
