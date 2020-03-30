public class Test {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }

    public static void main(String[] args) {
        Test test = new Test();
        String s = "abcdedcba";
        String str = "dgghhdkkj";
        System.out.println(test.isPalindrome(s));
        System.out.println(test.isPalindrome(str));
    }
}
