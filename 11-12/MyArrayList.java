import java.util.Arrays;

public class MyArrayList {
	
	private int[] arr;
	private int size;
	
	public MyArrayList() {
		arr = new int[10];
		size = 0;
	}
	
	//尾加
	public void pushBack(int element) {
		arr[size] = element;
		size++;
		
		//arr[size++] = element;
	}
	
	//尾删
	public void popBack() {
		arr[--size] = 0;
		
		//size -= 1;
		//arr[size] = 0;
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
		if(size == 0) {
			System.out.println("空了");
			return;
		}
		for(int i = 0;i < size-1;i++) {
			arr[i] = arr[i+1];
		}
		arr[--size] = 0;
	}
	
	public void insert(int element,int index) {
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

	@Override
	public String toString(){
		return Arrays.toString(Arrays.copyOf(arr,size));
	}
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		System.out.println(list);
		list.popBack();
		list.popBack();
		System.out.println(list);
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30);
		System.out.println(list);
		list.popFront();
		//list.popFront();
		System.out.println(list);
		list.insert(4,1);
		System.out.println(list);
		list.delete(1);
		System.out.println(list);
	}
}
	