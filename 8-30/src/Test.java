public class Test {
    public int recentCover(int target) {
        if (target ==0 || target==1 || target==2) {
            return target;
        }
        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
