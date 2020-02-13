import java.util.Arrays;

public class Arr {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(MyString[] args) {
        Arr test = new Arr();
        int[] arr = {1,2,10,8,3,4,9,4,5,6,7};
        int[] a = {2,3,17,12,4,5,6,8,7,10};
        System.out.println(test.containsDuplicate(arr));
        System.out.println(test.containsDuplicate(a));
    }
}
