public class TestString {
    public static void main(String[] args) {
        //String s = "s";
        //System.out.println("s="+s);
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a,b);
        System.out.println(a+" "+b);
    }

    private static void operate(StringBuffer a, StringBuffer b) {
        a.append(b);
        b = a;
    }
}
