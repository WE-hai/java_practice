public class Sum {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) {
            return addBinary(b, a);
        }// 两个String形式二进制数相加，大的在前，小的在后
        int L = Math.max(n, m);     //选出  那个string大，在题中，n大
        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;   //j为小string的长度减一
        for(int i = L - 1; i >= 0; --i) {    //倒序（i是 n的长度减一）
            if (a.charAt(i) == '1') {
                ++carry;
            }
            if (j>=0 && b.charAt(j--) == '1') {
                ++carry;
            }
                //如果  小字符串的长度>=0，而且小string的最后一位为1时（判断完了 j--，）carry再加一
            if (carry % 2 == 1) {
                sb.append('1');//当   carry等于1时，sb加入元素1，
            } else {
                sb.append('0');//否者，加入的时元素零
            }
            carry /= 2;//carry  =2时，carry是1，代入下一位的运算
        }
        if (carry == 1) {
            sb.append('1');
        }
        sb.reverse();//sb.reverse()就是用来把stringbuffer里面的字符串翻转
        return sb.toString();//sb.toString()就是返回该stringbuffer的字符串形式。
    }

    public static void main(String[] args) {
        Sum test = new Sum();
        String a = "11";
        String b = "1";
        System.out.println(test.addBinary(a,b));
    }
}
