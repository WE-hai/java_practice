import java.util.Arrays;
import java.util.Scanner;

public class Fill {
	
	public static int[] fill(int[] arr,int n) {
		for(int i = 0;i < arr.length;i++) {
			arr[i] = n;
		}
		return arr;
	}
	
	public static int[] fillOf(int[] arr,int from,int to,int n) {
		for(int i = from;i <= to;i++) {
			arr[i] = n;
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5,6,9};
		int[] arr2 = {2,6,7,5,3,4,8,9,10,13};
		System.out.println(Arrays.toString(arr1));
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入一个想填充的数：");
		int n = scanner.nextInt();
		System.out.println(Arrays.toString(fill(arr1,n)));
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println(Arrays.toString(arr2));
		System.out.print("请输入两个顺序下标区间：");
		int i = scanner.nextInt();
		int j = scanner.nextInt();
		System.out.println("请输入一个想填充的数：");
		int m = scanner.nextInt();
		System.out.println(Arrays.toString(fillOf(arr2,i,j,m)));
	}
}