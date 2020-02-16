public class ArrayZhong {
    public int pivotIndex(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int sum = 0;
        for(int i = 0;i < nums.length;i++) {
            sum += nums[i];
            left[i] = sum;
        }
        sum = 0;
        for(int i = nums.length-1;i >= 0;i--) {
            sum += nums[i];   right[i] = sum;
        }
        for(int i = 0;i < nums.length;i++) {
            if(left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayZhong test = new ArrayZhong();
        int[] arr = {1,7,3,6,5,6};
        System.out.println(test.pivotIndex(arr));
    }
}
