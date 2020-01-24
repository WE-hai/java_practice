public class Main {
    public static void printNumber(int n) {
        if (n < 10) {
            System.out.printf("%d ", n);
        } else {
            // 除了最低位之外，进行递归
            int m = n / 10;
            printNumber(m);
            // 打印最低位
            int o = n % 10;
            System.out.printf("%d ", n);
        }
    }

    public static int sumNumber(int n) {
        if (n < 10) {
            return n;
        } else {
            int m = n / 10;
            int o = n % 10;
            int h = sumNumber(m);
            int r = h + o;
            return r;
        }
    }

    // 0, 1, 2
    public static void hanoi(int n, int from, int to) {
        if (n == 1) {
            System.out.printf("从 %d 移动到 %d%n", from, to);
        } else {
            int other = 3 - from - to;
            hanoi(n - 1, from, other);
            System.out.printf("从 %d 移动到 %d%n", from, to);
            hanoi(n - 1, other, to);
        }
    }

    public static void main(String[] args) {
        printNumber(9527);	// "9 5 2 7 "
        System.out.println();
        System.out.println(sumNumber(9527));
        System.out.println();
        hanoi(5, 0, 2);
    }
}
