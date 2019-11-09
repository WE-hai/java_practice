import java.util.Arrays;

public class Equal {
	
	public static boolean equals(int[] a,int[] b) {
		if(a.length != b.length) {
			return false;
		} else {
			for(int i = 0;i < a.length;i++) {
				if(a[i] == b[i]) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		int[] b = {1,2,3,4,5,6,7};
		int[] c = {2,3,3,4,5,6};
		boolean ret1 = equals(a,b);
		boolean ret2 = equals(a,c);
		if(ret1 == true) {
			System.out.println("两个数组相同！");
		} else {
			System.out.println("两个数组不相同！");
		}
		System.out.println("a："+Arrays.toString(a));
		System.out.println("b："+Arrays.toString(b));
		
		if(ret2 == true) {
			System.out.println("两个数组相同！");
		} else {
			System.out.println("两个数组不同！");
		}
		System.out.println("a："+Arrays.toString(a));
		System.out.println("c："+Arrays.toString(c));
	}
}