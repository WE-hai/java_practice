public class Main {
    public static void main(String[] args) {
        String s = "hello";
        String s1 = "he"+new String("llo");
        System.out.println(s == s1);
    }
}
