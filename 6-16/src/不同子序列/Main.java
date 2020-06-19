package 不同子序列;

public class Main {
    public int numDistinct(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        int[][] numDis = new int[sLen + 1][tLen + 1];
        // F(i,j)，初始化第一行剩余列的所有值为0
        for (int i = 1; i <= tLen; i++) {
            numDis[0][i] = 0;
        }
        //F（i，0） = 1
        for (int i = 1;i <= sLen;i++) {
            for (int j = 1;j <= tLen;j++) {
                // S的第i个字符与T的第j个字符相同
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                    numDis[i][j] = numDis[i - 1][j] + numDis[i - 1][j - 1];
                } else {
                    // S的第i个字符与T的第j个字符不相同
                    // 从S的前i-1个字符中找子串，使子串与T的前j个字符相同
                    numDis[i][j] = numDis[i - 1][j];
                }
            }
        }
        return numDis[sLen][tLen];
    }

    public int numDistinct2(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        int[] numDis = new int[tLen + 1];
        numDis[0]= 1;
        for(int i = 1; i <= tLen; ++i){
            numDis[i] = 0;
        }
        for(int i = 1; i <= sLen; ++i){
            for(int j = tLen; j > 0; --j){
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                    numDis[j] = numDis[j] + numDis[j - 1];
                }
            }
        }
        return numDis[tLen];
    }
}
