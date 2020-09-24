package 题目2;

public class Main {
    public int maxSubArray (int[] nums) {
        // write code here
        int cur = nums[0];
        int max = nums[0];
        for (int i = 1;i < nums.length;i++) {
            cur = Math.max(cur+nums[i],nums[i]);
            max = Math.max(max,cur);
        }
        return max;
    }
}
