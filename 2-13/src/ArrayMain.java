import java.util.Arrays;

public class ArrayMain {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(MyString[] args) {
        ArrayMain test = new ArrayMain();
        int[] a = {1,2,3,4,0,0,0,0};
        int[] b = {5,6,7,8};
        test.merge(a,4,b,4);
        System.out.println(Arrays.toString(a));
    }
}
