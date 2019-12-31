import java.util.Arrays;

public class MyString {
    public static void main(String[] args) {
        String s = "javac -encoding UTF-8 MyString.java";
        String[] arg = s.split(" ");
        System.out.println(Arrays.toString(arg));

        String s1 = "www.baidu.com";
        String[] arg1 = s1.split("\\.");
        System.out.println(Arrays.toString(arg1));

        String[] arg2 = {"www","baidu","com"};
        String s3 = String.join(".",arg2);
        System.out.println(s3);
    }
}
