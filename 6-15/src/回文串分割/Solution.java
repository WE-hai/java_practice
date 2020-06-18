package 回文串分割;

public class Solution {
    public boolean[][] getMat(String s) {
        int len = s.length();
        boolean[][] mat = new boolean[len][len];
        for (int i = len-1;i >= 0;i--) {
            for (int j = i;j < len;j++) {
                if (j == i) {
                    mat[i][j] = true;
                } else if (j == i+1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        mat[i][j] = true;
                    } else {
                        mat[i][j] = false;
                    }
                } else {
                    mat[i][j] = (s.charAt(i) == s.charAt(j)) && mat[i+1][j-1];
                }
            }
        }
        return mat;
    }

    public int minCut(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        boolean[][] mat = getMat(s);
        int[] arr = new int[len+1];
        for (int i = 0;i <= len;i++) {
            arr[i] = i-1;
        }
        for (int i = 1;i <= len;i++) {
            for (int j = 0;j < i;j++) {
                if (mat[j][i-1]) {
                    arr[i] = Math.min(arr[i],arr[j]+1);
                }
            }
        }
        return arr[len];
    }
}
