import java.util.Arrays;

public class Main {
    public static int[] createArray(int n) {
        // 运行使用变量作为数组的长度
        return new int[n];
    }

    public static void printArray(int[] a) {
        // 获取数组的长度
		/*
		int size = a.length;

		for (int i = 0; i < size; i++) {
			System.out.println(a[i]);
		}
		*/

        for (int v : a) {
            System.out.println(v);
        }
    }

    public static int max1(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int v : a) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public static int max2(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static double average(int[] a) {
        int sum = 0;
        for (int v : a) {
            sum += v;
        }
        return (double)sum / a.length;
    }

    /**
     * 在数组 a 中查找 v 第一次出现的下标
     * 如果没找到，返回 -1
     */
    public static int indexOf(int[] a, int v) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == v) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在数组 a 中查找 v 最后一次出现的下标
     * 如果没找到，返回 -1
     */
    public static int lastIndexOf(int[] a, int v) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == v) {
                return i;
            }
        }
        return -1;
    }
    /*
     * 复制给定的数组，参数中会给出需要复制的下标范围
     * from: 起始下标
     * to: 终止下标
     * [from, to)
     */
    public static int[] copyOfRange(int[] a, int from, int to) {
        int[] b = new int[to - from];
        for (int i = from; i < to; i++) {
            b[i - from] = a[i];
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = createArray(10);
        System.out.println(Arrays.toString(a));
        printArray(a);
        printArray(new int[] { 3, 5, 2, 7, 9, 4, 8 });

		int[] arr = { 4, 2, 1, 9, 8, 3, 7 };
		System.out.println(max1(arr));
		System.out.println(max2(arr));
		System.out.println(average(arr));

		int[] b = { 5, 1, 2, 4, 3, 8, 5, 2 };
		System.out.println(indexOf(b, 5));
		System.out.println(lastIndexOf(b, 5));

        int[] array = { 1, 3, 4, 2, 6 };
        int[] b1 = copyOfRange(a, 1, 3);
        System.out.println(Arrays.toString(b1));
    }
}
