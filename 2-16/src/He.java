import java.util.Arrays;

public class He {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int flag = target - nums[i];
            // j = i + 1 的目的是减少重复计算和避免两个元素下标相同
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == flag){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        He test = new He();
        int[] arr = {1,3,4,6,7,8};
        System.out.println(Arrays.toString(test.twoSum(arr,7)));
        System.out.println(Arrays.toString(test.twoSum(arr,3)));
        System.out.println(Arrays.toString(test.twoSum(arr,13)));
    }
}
