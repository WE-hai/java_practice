import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // j ~ [0, a.length - i - 1)
            for (int j = 0; j < a.length - i - 1; j++) {
                // j 和 j + 1 下标对比
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // j ~ [0, a.length - i - 1)
            for (int j = 1; j < a.length - i; j++) {
                // j 和 j - 1
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }

    public static int binarySearch(int[] a, int v) {
        // 查找的范围是 [left, right)
        int left = 0;
        int right = a.length;

        // 只要 [left, right) 代表的区间内还有数
        // 就表示还有希望，继续查找
        while (left < right) {
            int mid = (left + right) / 2;
            if (v == a[mid]) {
                return mid;
            } else if (v < a[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearch2(int[] a, int v) {
        // 查找的范围是 [left, right]
        int left = 0;
        int right = a.length - 1;

        // 只要 [left, right] 代表的区间内还有数
        // 就表示还有希望，继续查找
        while (left <= right) {
            int mid = (left + right) / 2;
            if (v == a[mid]) {
                return mid;
            } else if (v < a[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 进行数组的复制，返回一个新的数组，数组长度是 newLength
     * 如果 newLength <= 原数组长度的，进行截取
     * 如果 newLength > 原数组长度, 其余位置用 0 填充
     */
    public static int[] copyOf(int[] a, int newLength) {
        int[] dest = new int[newLength];
        // dest 现在的元素值是多少	0
        // int length = newLength < a.length ? newLength : a.length;
        int length = Math.min(newLength, a.length);
        for (int i = 0; i < length; i++) {
            dest[i] = a[i];
        }

        return dest;
    }

    public static int[] copyOfRange(int[] a, int from, int to) {
        int[] dest = new int[to - from];
        for (int i = from; i < to; i++) {
            dest[i - from] = a[i];
        }

        return dest;
    }

    public static void fill(int[] a, int val) {
        for (int i = 0; i < a.length; i++) {
            a[i] = val;
        }
    }

    public static void fill(int[] a, int from, int to, int val) {
        for (int i = from; i < to; i++) {
            a[i] = val;
        }
    }

    public static boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

		int[] aFromArgs = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			aFromArgs[i] = Integer.parseInt(args[i]);
		}

        Scanner scanner = new Scanner(System.in);
        int[] aFromScanner = new int[5];
        for (int i = 0; i < 5; i++) {
            aFromScanner[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(aFromScanner));
		
		

		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 5, 4, 3, 2, 1 };
		int[] c = { 3, 3, 3, 3, 3 };
		int[] d = { 1, 9, 3, 7, 7 };
		bubbleSort(a);
		bubbleSort(b);
		bubbleSort(c);
		bubbleSort(d);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));
		System.out.println(binarySearch(a, 3));
		
		
		int[] e = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(copyOf(e, 3)));
		System.out.println(Arrays.toString(copyOf(e, 5)));
		System.out.println(Arrays.toString(copyOf(e, 7)));

    }
}