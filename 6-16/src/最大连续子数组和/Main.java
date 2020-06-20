package 最大连续子数组和;

public class Main {
    public int findGreatestSumOfSubArray(int[] array) {
        //F(i)初始化  maxSum初始化
        int maxSum = array[0],curSum = array[0];
        for (int i = 1;i < array.length;i++) {
            //F(i) = max(F(i-1) + array[i]，array[i])
            curSum = Math.max(curSum+array[i],array[i]);
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}
