public class MyString {
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        for(int j=0;j<typed.length();j++) {
            if(name.charAt(i)==typed.charAt(j)){
                i++;
            }
            if(i==name.length()) {
                break;
            }
        }return i==name.length()?true:false;
    }

    public static void main(String[] args) {
        MyString test = new MyString();
        String s1 = "asdf";
        String s2 = "aasdff";
        System.out.println(test.isLongPressedName(s1,s2));
        String s3 = "cddhu";
        String s4 = "ccdhu";
        System.out.println(test.isLongPressedName(s3,s4));
    }
}
