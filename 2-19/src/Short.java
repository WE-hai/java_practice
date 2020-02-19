public class Short {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int R = 0;
        int L = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) {
                R = i;
            }
            max = Math.max(max, nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (min < nums[i]) {
                L = i;
            }
            min = Math.min(min, nums[i]);
        }
        return R == L ? 0 : R - L + 1;
    }

    public static void main(String[] args) {
        Short test = new Short();
        int[] arr = {1,6,7,2,5,8,3,4,9};
        System.out.println(test.findUnsortedSubarray(arr));
    }
}
