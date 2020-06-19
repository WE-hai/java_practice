package 编辑距离;

public class Main {
    public int minDistance(String word1, String word2) {
        // word与空串之间的编辑距离为word的长度
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.max(word1.length(), word2.length());
        }
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] minDis = new int[len1 + 1][len2 + 1];
        // F(i,j)初始化
        for (int i = 0; i <= len1; i++) {
            minDis[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            minDis[0][i] = i;
        }
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                // F(i,j) = min { F(i-1,j）+1, F(i,j-1) +1, F(i-1,j-1) +(w1[i]==w2[j]?0:1) }
                minDis[i][j] = 1 + Math.min(minDis[i - 1][j], minDis[i][j - 1]);
                // 判断word1的第i个字符是否与word2的第j个字符相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 字符相等，F(i-1,j-1)编辑距离不变
                    minDis[i][j] = Math.min(minDis[i][j], minDis[i - 1][j - 1]);
                } else {
                    // 字符不相等，F(i-1,j-1)编辑距离 + 1
                    minDis[i][j] = Math.min(minDis[i][j], minDis[i - 1][j - 1] + 1);
                }
            }
        }
        return minDis[len1][len2];
    }

}
