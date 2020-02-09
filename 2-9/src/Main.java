public class Main {
    public static int fn(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 4;
        } else {
            return 2*fn(n-1)+fn(n-2);
        }
    }
    public static void main(String[] args) {
        float f[][] = new float[6][6];
        float [][]f1 = new float[6][6];
        float[][] f3 = new float[6][];
        System.out.println(fn(10));

    }
}
