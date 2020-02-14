import java.util.Arrays;

public class SortSquare {
    public int[] sortSquares(int[] a) {
        int[] arr = new int[a.length];
        for (int i = 0;i < a.length;i++) {
            arr[i] = a[i]*a[i];
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        SortSquare test = new SortSquare();
        int[] arr = {1,3,-4,5,6,2,9,7};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(test.sortSquares(arr)));
    }
}
