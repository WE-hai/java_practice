public class Test {
    public static void method() {
        System.out.println("test");
    }
    public static void main(String[] args) {
        ((Test)null).method();
        String x = "fmn";
        x.toUpperCase();
        String y = x.replace('f','F');
        y = y+"xwy";
        System.out.println(y);
    }
}
