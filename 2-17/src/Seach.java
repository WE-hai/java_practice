import java.util.Arrays;

public class Seach {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }
        if (targetRange[0] == -1) {
            return targetRange;
        }
        for (int j = nums.length-1; j >= 0; j--) {
            if (nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }
        return targetRange;
    }

    public static void main(String[] args) {
        Seach test = new Seach();
        int[] arr = {1,2,4,4,8,6,6,9,9,10};
        System.out.println(Arrays.toString(test.searchRange(arr,4)));
        System.out.println(Arrays.toString(test.searchRange(arr,6)));
        System.out.println(Arrays.toString(test.searchRange(arr,8)));
        System.out.println(Arrays.toString(test.searchRange(arr,3)));
    }
}
