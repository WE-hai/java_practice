package 二维数组打印;

public class Main {
    /**
     *  题意很简单，主要是边界的处理：
     *   1. 沿着主对角线打印，所以每次打印之后x与y都要加1，直到x或y超出边界。
     *   2. 每轮遍历的起始点，是遵循(0,n-1)...（0,0）...（n-1,0）。
     *           也就是y先减小到0，然后x增加到n-1。所以遍历的终止条件是startX>=n。 *
     **/
    public int[] arrayPrint(int[][] arr, int n) {
        int[] ret = new int[n*n];
        int idx = 0;
        int dx = 0;
        int dy = n-1;
        while (dx < n) {
            int x = dx;
            int y = dy;
            while (x < n && y < n) {
                ret[idx++] = arr[x++][y++];
            }
            if (dy > 0) {
                dy--;
            } else {
                dx++;
            }
        }
        return ret;
    }
}
