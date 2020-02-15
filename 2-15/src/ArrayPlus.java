import java.util.Arrays;

public class ArrayPlus {
    public int[] plusOne(int[] arr) {
        for (int i = arr.length-1;i >= 0;i--) {
            arr[i]++;
            arr[i] = arr[i] % 10;
            if (arr[i] != 0) {
                return arr;
            }
        }
        arr = new int[arr.length+1];
        arr[0] = 1;
        return arr;
    }

    public static void main(String[] args) {
        ArrayPlus test = new ArrayPlus();
        int[] arr1 = {9};
        int[] arr2 = {1,2,3,4};
        System.out.println(Arrays.toString(test.plusOne(arr1)));
        System.out.println(Arrays.toString(test.plusOne(arr2)));
    }
}
