public class ArrayTest {
    public boolean conConstruct(String s1, String s2) {
        int[] num = new int[26];
        for (int i = 0;i < s2.length();i++) {
            num[s2.charAt(i)-'a']++;
        }
        for (int i = 0;i < s1.length();i++) {
            if (num[s1.charAt(i)-'a'] == 0) {
                return false;
            }
            num[s1.charAt(i)-'a']--;
        }
        return true;
    }

    public static void main(MyString[] args) {
        ArrayTest test = new ArrayTest();
        String s1 = "aabcdefg";
        String s2 = "abcfg";
        String s3 = "aaabcghu";
        System.out.println(test.conConstruct(s3,s1));
        System.out.println(test.conConstruct(s1,s2));
        System.out.println(test.conConstruct(s2,s3));
    }
}

