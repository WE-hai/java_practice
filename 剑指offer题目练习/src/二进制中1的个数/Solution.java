package 二进制中1的个数;

public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);
        String[] strings = s.split("");
        for (int i = 0;i < strings.length;i++) {
            if (strings[i].equals("1")) {
                count++;
            }
        }
        return count;
    }
}
