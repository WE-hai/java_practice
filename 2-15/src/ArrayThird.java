import java.util.Arrays;

public class ArrayThird {
    public int thirdMax(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        if(nums.length < 3) {
            return nums[nums.length-1];
        }
        int third = 2;
        int i;
        for(i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]) {
                third = third - 1;
            }
            if(third == 0) {
                break;
            }
        }
        if(third == 0) {
            return nums[i];
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        ArrayThird test = new ArrayThird();
        int[] arr = {2,6,8,10,3,15,9,1,4,12};
        System.out.println(test.thirdMax(arr));
    }
}
