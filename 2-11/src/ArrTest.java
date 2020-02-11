import java.util.Arrays;

public class ArrTest {
    public int removeElement(int[] arr,int val) {
        int i = 0;
        for (int j = 0;j < arr.length;j++) {
            if (arr[j] != val) {
                arr[i] = arr[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        ArrTest test = new ArrTest();
        int[] arr = {3,3,4,4,5,6,3};
        System.out.println(Arrays.toString(arr));
        System.out.println(test.removeElement(arr,3));
    }
}
