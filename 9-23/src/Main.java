public class Main {
    public static int method() {
        int a = 0;
        try {
            a = 3;
            System.out.println(a);
            int x = a/0;
        } catch (Throwable e1) {
            System.exit(0);
        } finally {
            a++;
            System.out.println(a);
            return a;
        }
    }
    public static void main(String[] args) {
        method();
    }
}
