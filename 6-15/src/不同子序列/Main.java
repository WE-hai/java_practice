package 不同子序列;

public class Main {
    public int numDistinct(String S,String T) {
        int Slen = S.length();
        int Tlen = T.length();
        int[][] numDis = new int[Slen+1][Tlen+1];
        numDis[0][0] = 1;
        for (int i = 1;i <= Tlen;i++) {
            numDis[0][i] = 0;
        }
        for (int i = 1;i <= Slen;i++) {
            numDis[i][0] = 1;
        }
        for (int i = 1;i <= Slen;i++) {
            for (int j = 1;j <= Tlen;j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    numDis[i][j] = numDis[i-1][j]+numDis[i-1][j-1];
                } else {
                    numDis[i][j] = numDis[i-1][j];
                }
            }
        }
        return numDis[Slen][Tlen];
    }
}
