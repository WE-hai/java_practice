import java.util.Arrays;

public class MyArrayList {
    private int[] arr;
    private int size;

    public MyArrayList(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public MyArrayList() {
        this(10);
    }

    //尾加
    public void pushBack(int element) {
        if(!checkCapacity(1)) {
            ensureCapacity();
        }
        arr[size] = element;
        size++;
        //arr[size++] = element;

        //insert(size,element);
    }

    //尾删
    public void popBack() {
        arr[--size] = 0;

        //size -= 1;
        //arr[size] = 0;


        //delete(size);
    }

    //头插
    public void pushFront(int element) {
        if(!checkCapacity(1)) {
            ensureCapacity();
        }
        for(int i = size;i > 0;i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = element;
        size++;


        //insert(0,element);
    }

    //头删
    public void popFront() {
        if(size == 0) {
            System.out.println("空了");
            return;
        }
        for(int i = 0;i < size-1;i++) {
            arr[i] = arr[i+1];
        }
        arr[--size] = 0;


        //delete(0);
    }

    public void insert(int element,int index) {
        if(!checkCapacity(1)) {
            ensureCapacity();
        }
        for(int i = size;i > index;i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;

    }

    public void delete(int index) {
        for(int i = index;i < size-1;i++) {
            arr[i] = arr[i+1];
        }
        arr[--size] = 0;
    }

    private boolean checkCapacity(int num) {
        return size + num <= arr.length;
    }

    private void ensureCapacity() {
        int newLength = arr.length*2;
        int[] newarr = new int[newLength];
        for(int i = 0;i < size;i++) {
            newarr[i] = arr[i];
        }
        this.arr = newarr;

        //arr = Arrays.copyOf(arr,arr.length);
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(arr,size));
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(3);
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        System.out.println(list);
        System.out.println(list.arr.length);
        list.popBack();
        list.popBack();
        System.out.println(list);
        list.pushFront(10);
        list.pushFront(20);
        list.pushFront(30);
        System.out.println(list);
        System.out.println(list.arr.length);
        list.popFront();
        list.popFront();
        System.out.println(list);
        list.insert(4,1);
        System.out.println(list);
        list.delete(1);
        System.out.println(list);
    }
}