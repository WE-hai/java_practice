import java.util.Arrays;

public class Solution {
    //两数之和
    public int[] twoSum(int[] arr,int element) {
        int[] ret = new int[2];
        for (int i = 0;i < arr.length;i++) {
            int flag = element-arr[i];
            for (int j = i+1;j < arr.length;j++) {
                if (flag == arr[j]) {
                    ret[0] = i;
                    ret[1] = j;
                }
            }
        }
        return ret;
    }

    //预约按摩师
    public int massage(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        arr[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i < arr.length;i++) {
            arr[i] = Math.max(arr[i-1],arr[i-2]+nums[i]);
        }
        return arr[arr.length-1];
    }

    //整数反转
    public int reverse(int x) {
        long ret = 0;
        while(x != 0) {
            ret = ret*10+x%10;
            x = x/10;
        }
        if((int)ret != ret) {
            return 0;
        } else {
            return (int)ret;
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] arr = {3,6,7,1,8,4,7,10};
        System.out.println("预约按摩师: "+test.massage(arr));
        System.out.println("整数反转: "+test.reverse(6438));
        System.out.println("两数之和: "+Arrays.toString(test.twoSum(arr,13)));
    }
}
