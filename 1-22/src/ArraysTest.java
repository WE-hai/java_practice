import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        int[] a = {3,4,5,6};
        int[] b = {3,4,5,6};
        System.out.println("a和b是否相等："+ Arrays.equals(a,b));
        int[] c = Arrays.copyOf(a,6);
        System.out.println("a和c是否相等："+ Arrays.equals(a,c));
        System.out.println("c数组的元素："+ Arrays.toString(c));
        Arrays.fill(c,2,4,1);
        System.out.println("c数组的元素："+ Arrays.toString(c));
        Arrays.sort(c);
        System.out.println("c数组的元素："+ Arrays.toString(c));
    }
}
