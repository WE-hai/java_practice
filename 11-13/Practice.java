import java.util.Arrays;

class MyArrayList {
	
	private int[] arr;
	private int size;
	
	public MyArrayList() {
		arr  = new int[10];
		size = 0;
	}
	
	@Override
	public String toString(){
		return Arrays.toString(Arrays.copyOf(arr,size));
	}
	
	//尾插
	public void pushBack(int element) {
		arr[size++] = element;
	}
	
	//尾删
	public void popBack() {
		arr[--size] = 0;
	}
	
	//头插
	public void pushFront(int element) {
		for(int i = size;i > 0;i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = element;
		size++;
	}
	
	//头删
	public void popFront() {
		for(int i = 0;i < size-1;i++) {
			arr[i] = arr[i+1];
		}
		arr[--size] = 0;
	}
	
}

public class Practice {
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		System.out.println(list);
		list.popBack();
		list.popBack();
		System.out.println(list);
		list.pushFront(4);
		list.pushFront(5);
		list.pushFront(6);
		System.out.println(list);
		list.popFront();
		list.popFront();
		System.out.println(list);
	}
}