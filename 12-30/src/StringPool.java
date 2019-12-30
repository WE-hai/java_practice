public class StringPool {
    public static void main(String[] args) {
       /*
        String s = "hello";
        String p = "hello";
        String q = "hello";

        //判断String是否相等
        System.out.println(s.equals(p));
        System.out.println(s.equals(q));

        System.out.println(s == p);
        System.out.println(s == q);
        */
        String s = "hello";
        String p = new String(s);
        String q = new String(s);
        System.out.println(s.equals(p));
        System.out.println(s.equals(q));

        System.out.println(s == p);
        System.out.println(s == q);
        System.out.println();
        String a = "hello" + " " + "world";
        String b = "hello world";
        System.out.println(a == b);
        System.out.println();
        String c = "hello";
        String d = new String(c);
        d = d.intern();
        System.out.println(c == d);
    }
}
