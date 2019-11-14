import java.util.Arrays;

// 顺序表中存储的元素的类型是 int 类型
public class MyArrayList {
	private int[] array;
	private int size;
	
	public MyArrayList() {
		array = new int[10];
		size = 0;
	}
	
	// 尾插
	// 时间复杂度 O(1)
	// 空间复杂度 O(1)
	public void pushBack(int element) {
		/*
		array[size] = element;
		size++;
		*/
		array[size++] = element;
	}
	
	// 尾删
	// 时间复杂度 O(1)
	// 空间复杂度 O(1)
	public void popBack() {
		if (size <= 0) {
			// 最好用异常
			System.out.println("空了");
			return;
		}
		array[--size] = 0;
	}
	
	public void pushFront(int element) {
		// 把原有数据全部后移一格
		/*
		// i 代表的含义：实心
		for (int i = size - 1; i >= 0; i--) {
			// array[空心] = array[实心]
			array[i + 1] = array[i];
		}
		*/
		// i 代表的含义：空心
		for (int i = size; i > 0; i--) {
			array[i] = array[i - 1];
		}
		// 把新的元素放到 0 下标处
		array[0] = element;
		// 长度 + 1
		size++;
	}
	
	void popFront() {
		if (size == 0) {
			System.out.println("空了");
			return;
		}
		
		// i 实心
		for (int i = 1; i <= size - 1; i++) {
			array[i - 1] = array[i];
		}
		
		array[--size] = 0;
	}
	
	public void insert(int element, int index) {
		// i: 实心
		for (int i = size - 1; i >= index; i--) {
			array[i + 1] = array[i];
		}
		array[index] = element;
		size++;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(array, size));
	}
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30);
		System.out.println(list); // 30 20 10 1 2 3
		list.popFront();
		list.popFront();
		System.out.println(list); // 10 1 2 3
		list.insert(100, 2);	
		System.out.println(list); // 10 1 100 2 3
		/*
		list.popBack();
		list.popBack();
		System.out.println(list);
		list.popBack();
		System.out.println(list);
		list.popBack();
		*/
	}
}


