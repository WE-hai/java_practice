import java.util.Arrays;

public class BinarySeach {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if (mid == nums[mid]) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        BinarySeach test = new BinarySeach();
        int[] arr = {1,2,3,4,5,6};
        System.out.println(test.searchInsert(arr,3));
        System.out.println(test.searchInsert(arr,6));
        System.out.println(test.searchInsert(arr,8));
        System.out.println(Arrays.toString(arr));
    }
}
