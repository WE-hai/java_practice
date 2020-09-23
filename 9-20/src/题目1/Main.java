package 题目1;

import java.util.*;

public class Main {
    public int thirdMax (int[] nums) {
        // write code here
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length-1;i > 0;i--) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
            if (list.size() == 3) {
                return list.get(2);
            }
        }
        return nums[nums.length-1];
    }
}
