
public class StringDemo {
    public static void main(String[] args) {
        String s = "hello world!";
        char[] c = s.toCharArray();
        for(int i = 0;i < c.length;i++) {
            System.out.println(c[i] + " ");
        }
        System.out.println(new String(c));
        System.out.println(new String(c,5,5));
    }

}
