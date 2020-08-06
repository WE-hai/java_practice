public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = s1;
        System.out.println("s1 = "+s1+" "+"s2 = "+s2);
        s1 = "world";
        System.out.println("s2 = "+s2);
        s2 = s1;
        System.out.println("s2 = "+s2);
    }
}
