public class StringTest {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        if(s.length()==0){
            return 0;
        }
        int last = s.lastIndexOf(" ");
        return s.length()-1-last;
    }

    public static void main(MyString[] args) {
        StringTest test = new StringTest();
        String s = "hello world please protect environment";
        String str = "what is your name";
        System.out.println(test.lengthOfLastWord(s));
        System.out.println(test.lengthOfLastWord(str));
    }
}
