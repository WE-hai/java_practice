package 跳台阶;

public class Main {
    public int jumpFloor(int target) {
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
