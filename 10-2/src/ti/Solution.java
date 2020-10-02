package ti;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        char[] chars = J.toCharArray();
        for (int i = 0;i < chars.length;i++) {
            for (int j = 0;j < S.length();j++) {
                if (chars[i] == S.charAt(j)) {
                    count++;
                    continue;
                }
            }
        }
        return count;
    }
}
