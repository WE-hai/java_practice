public class JuzhenZuichanglujing {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return 0;
        }
        int x = matrix[0].length;
        int y = matrix.length;
        int[][] cache = new int[matrix.length][matrix[0].length];
        int rtn = 1;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                //System.out.println("i:" + i + ",j:" + j);
                int max = dfs(matrix, j, i, cache);
                if (max > rtn) {
                    rtn = max;
                }
            }
        }
        return rtn;
    }
    public int dfs(int[][] matrix, int x, int y, int[][] cache) {
        //越界退出
        if (x < 0 || x > matrix[0].length - 1 || y < 0 || y > matrix.length - 1) {
            return 0;
        }
        //如果之前这个位置已经计算过了,则直接返回
        if (cache[y][x] != 0) return cache[y][x];
        //左
        Integer l = x > 0 && y >= 0 ? matrix[y][x - 1] : null;
        //右
        Integer r = x + 1 < matrix[0].length ? matrix[y][x + 1] : null;
        //上
        Integer u = y > 0 ? matrix[y - 1][x] : null;
        //下
        Integer d = y + 1 < matrix.length ? matrix[y + 1][x] : null;
        int value = matrix[y][x];
        int left = 0, up = 0, right = 0, down = 0, max = 0;
        if (l != null && l > value) {
            left = dfs(matrix, x - 1, y, cache);
        }
        if (u != null && u > value) {
            up = dfs(matrix, x, y - 1, cache);
        }
        if (r != null && r > value) {
            right = dfs(matrix, x + 1, y, cache);
        }
        if (d != null && d > value) {
            down = dfs(matrix, x, y + 1, cache);
        }
        //找出最大的那个方向
        max = Math.max(max, left);
        max = Math.max(max, up);
        max = Math.max(max, right);
        max = Math.max(max, down);
        //最后加上自己
        if (max > 0) {
            cache[y][x] = 1 + max;
        } else {
            //只有自己
            cache[y][x] = 1;
        }
        return cache[y][x];
    }

    public static void main(String[] args) {
        JuzhenZuichanglujing test = new JuzhenZuichanglujing();
        int[][] arr = {{1,2,3},{1,2,3}};
        System.out.println(test.longestIncreasingPath(arr));
    }
}
