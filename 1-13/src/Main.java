import java.util.Arrays;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3,-4,25,16,30,15};
        Arrays.parallelSort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = new int[]{3,-4,25,16,30,15};
        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left*right;
            }
        });
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = new int[5];
        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand*5;
            }
        });
        System.out.println(Arrays.toString(arr3));
    }
}
