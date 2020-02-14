public class FanzhuanString {
    public String reverseOnlyLetters(String S) {
        char[] a = new char[S.length()];
        int j = 0;
        int[] index = new int[S.length()];
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < S.length();i++){
            char c = S.charAt(i);
            if((c <= 'z' && c >= 'a')||(c <= 'Z' && c >= 'A')){
                sb.append(c);
            } else {
                a[j] = c;
                index[j] = i;
                j++;
            }
        }
        sb.reverse();
        for(int i = 0;i < j;i++){
            sb.insert(index[i],a[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FanzhuanString test = new FanzhuanString();
        String s = "hello world,Tom-and-Amy";
        System.out.println(s);
        System.out.println(test.reverseOnlyLetters(s));
    }
}
