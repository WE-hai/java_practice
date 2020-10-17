package 替换空格;

public class Solution {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        String string = s.replaceAll(" ","%20");
        return string;
    }
}
