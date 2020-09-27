package 搜狗题目1;

class Interval {
     int start;
     int end;
}
public class Mian {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回Interval类，start代表汪仔最少做对了多少道题，end代表汪仔最多做对了多少道题。
     * @param n int整型 选择题总数
     * @param k int整型 朋友做对的题数
     * @param str1 string字符串 长度为n只包含ABCD的字符串，其中第i个代表汪仔第i题做出的选择
     * @param str2 string字符串 长度为n只包含ABCD的字符串，其中第i个代表朋友第i题做出的选择
     * @return Interval类
     */
    public Interval solve (int n, int k, String str1, String str2) {
        // write code here
        Interval ques = new Interval();
        if (n < k) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < str1.length();i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
            }
        }
        if (sb.length() == k && sb.length() == n) {
            ques.start = ques.end = k;
            return ques;
        }
        if (sb.length() == 0) {
            ques.start = 0;
            ques.end = n;
            return ques;
        }
        if (sb.length() > n-k) {
            ques.start = k;
            ques.end = n-k;
            return ques;
        }
        if (sb.length() < n-k) {
            ques.start = k;
            ques.end = n;
            return ques;
        }
        return null;
    }
}