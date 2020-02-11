import java.util.Arrays;

public class ArrayTest {
    public void rotate(int[] arr,int k) {
        int tmp;
        int prev;
        for (int i = 0;i < k;i++) {
            prev = arr[arr.length-1];
            for (int j = 0;j < arr.length;j++) {
                tmp = arr[j];
                arr[j] = prev;
                prev = tmp;
            }
        }
    }

    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(arr));
        test.rotate(arr,4);
        System.out.println(Arrays.toString(arr));
    }
}
