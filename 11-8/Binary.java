import java.util.Arrays;
import java.util.Scanner;

public class Binary {
	
	public static int binarySort(int[] arr,int n) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(arr[mid] > n) {
				right = mid - 1;
			} else if(arr[mid] < n) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,5,8,9,13,18,21,33,47,53};
		Scanner scanner = new Scanner(System.in);
		System.out.println(Arrays.toString(arr));
		System.out.print("请输入一个要找的数：");
		int n = scanner.nextInt();
		int ret = binarySort(arr,n);
		System.out.println("下标是："+ret);
	}
}