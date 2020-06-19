package 变态青蛙跳台阶;

public class Main {
    public int jumpFloor1(int target) {
        int ret = 1;
        for (int i = 2;i <= target;i++) {
            ret *= 2;
        }
        return ret;
    }

    public int jumpFloor2(int target) {
        return 1 << (target-1);
    }
}
