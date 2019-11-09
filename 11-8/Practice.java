import java.util.Arrays;

public class Practice {
	public static void swap(int[] arr,int i,int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	public static int[] bubbleSort(int[] arr) {
		for(int i = 0;i < arr.length;i++) {
			for(int j = 0;j < i;j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = {2,3,5,1,7,2,6,9};
		System.out.println(Arrays.toString(bubbleSort(arr)));
	}
}