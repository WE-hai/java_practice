public class Main {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int curSum = array[0];
        for(int i = 1;i < array.length;i++) {
            curSum = Math.max(curSum+array[i],array[i]);
            if(curSum > max) {
                max = curSum;
            }
        }
        return max;
    }

    public int JumpFloor(int target) {
        /*
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
        */
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }
        int[] arr = new int[target+1];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3;i <= target;i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[target];
    }
}
