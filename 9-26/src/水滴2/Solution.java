package 水滴2;

public class Solution {
    public int sumArray(int[] arr) {
        int curSum = arr[0];
        int maxSum = curSum;
        for (int i = 0;i < arr.length;i++) {
            curSum = Math.max(curSum+arr[i],arr[i]);
            maxSum = Math.max(curSum,maxSum);
        }
        return maxSum;
    }
}
