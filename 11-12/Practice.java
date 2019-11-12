import java.util.Arrays;
import java.util.Scanner;

public class Practice {
	
	public static void swap(int[] arr,int i,int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static int[] bubbleSort(int[] arr) {
		for(int i = 0;i < arr.length;i++) {
			for(int j = 0;j <arr.length - i -1;j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
		return arr;
	}
	
	public static int binarySearch(int[] arr,int n) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int mid = (left + right)/2;
			if(arr[mid] == n) {
				return mid;
			} else if(arr[mid] < n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {8,3,1,6,2,9,5,4,10,7};
		int[] arr2 = {2,4,6,7,9,12,13,22,34,56};
		Scanner scanner = new Scanner(System.in);
		System.out.println(Arrays.toString(arr2));
		System.out.print("请输入要找的数：");
		int n = scanner.nextInt();
		int a = binarySearch(arr2,n);
		System.out.println("下标是："+a);
		System.out.println(Arrays.toString(arr1));
		System.out.println("排序后的数组："+Arrays.toString(bubbleSort(arr1)));
	}
}