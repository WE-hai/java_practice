package 回文串分割;

public class Main {
    //判断是否回文串
    public boolean isPal(String s,int start,int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public int minCut(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] minCut = new int[len+1];
        //F（i）初始化
        //F(0) = -1，必要项，如果没有这一项对于重叠字符串“aaaaa”会产生错误结果
        for (int i = 0;i <= len;i++) {
            minCut[i] = i-1;
        }
        for (int i = 1;i <= len;i++) {
            for (int j = 0;j < i;j++) {
                // F(i) = min{F(i), 1 + F(j)}, where j<i && j+1到i是回文串
                // 从最长串判断，如果从第j+1到i为回文字符串
                // 则再加一次分割，从1到j，j+1到i的字符就全部分成了回文字符串
                if (isPal(s,j,i-1)) {
                    minCut[i] = Math.min(minCut[i],minCut[j]+1);
                }
            }
        }
        return minCut[len];
    }

    public boolean[][] getMat(String s) {
        int len = s.length();
        boolean[][] mat = new boolean[len][len];
        for (int i = len-1;i >= 0;i--) {
            for (int j = i;j < len;j++) {
                if (j == i) {
                    //单字符串为回文串
                    mat[i][j] = true;
                } else if (j == i+1) {
                    //相邻字符如果相等，则为回文字符串
                    if (s.charAt(i) == s.charAt(j)) {
                        mat[i][j] = true;
                    } else {
                        mat[i][j] = false;
                    }
                } else {
                    // F(i,j) = {s[i]==s[j] && F(i+1,j-1)
                    // j > i+1
                    mat[i][j] = (s.charAt(i) == s.charAt(j)) && mat[i+1][j-1];
                }
            }
        }
        return mat;
    }
    public int minCut2(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        boolean[][] mat = getMat(s);
        int[] minCut = new int[len+1];
        //F(i)初始化
        // F(0）= -1，必要项，如果没有这一项，对于重叠字符串“aaaaa”会产生错误的结果
        for (int i = 0;i <= len;i++) {
            minCut[i] = i-1;
        }
        for (int i = 1;i <= len;i++) {
            for (int j = 0;j < i;j++) {
                // F(i) = min{F(i), 1 + F(j)}, where j<i && j+1到i是回文串
                // 从最长串判断，如果从第j+1到i为回文字符串
                // 则再加一次分割，从1到j，j+1到i的字符就全部分成了回文字符串
                if (mat[j][i-1]) {
                    minCut[i] = Math.min(minCut[i],minCut[j]+1);
                }
            }
        }
        return minCut[len];
    }
}
