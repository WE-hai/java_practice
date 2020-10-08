package 变态青蛙跳台阶;

public class Solution {
    public int JumpFloorII(int target) {
        int ret = 1;
        for(int i = 2;i <= target;i++) {
            ret *= 2;
        }
        return ret;
    }
}
