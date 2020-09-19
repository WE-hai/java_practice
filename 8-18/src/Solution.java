public class Solution {
    //变态青蛙跳台阶
    public int JumpFloorII(int target) {
        int ret = 1;
        for(int i = 2; i <= target; ++i){
            ret *= 2;   //ret = ret*2
       }
        return ret;
   }

    public int JumpFloorII2(int target) {
        return 1 <<(target - 1);
    }
}
