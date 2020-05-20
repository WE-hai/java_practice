package 空格替换;

public class Replacement {
    public static String replaceSpace(String iniString, int length) {
        String replace = iniString.replace(" ", "%20");
        return replace;
    }

    public static void main(String[] args) {
        String s = "Hello world";
        String ret = replaceSpace(s,10);
        System.out.println(ret);
    }
}
