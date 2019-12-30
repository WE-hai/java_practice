import java.io.UnsupportedEncodingException;

public class StringMethod {
    private static boolean isNumber(String s) {
        for(char c : s.toCharArray()) {  //遍历方式
            if (!Character.isDigit(c)) {
                return false;
            }
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    private static byte[] transform(byte[] b,String fromCharset,String toCharset) throws UnsupportedEncodingException {
        String s = new String(b,fromCharset);
        return s.getBytes(toCharset);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        /*
        byte[] s = "中国人".getBytes("UTF-8");
        byte[] s1 = "中国人".getBytes("GB18030");
        for (byte b : s) {
            System.out.printf("\\x%x",b);
        }
        System.out.println();
        for (byte b : s1) {
            System.out.printf("\\x%x",b);
        }
        System.out.println();
        */
        System.out.println("abc".compareTo("bbc"));
        System.out.println("abc".compareTo("abcd"));
        System.out.println("bbcd".compareTo("abc"));
    }

}
