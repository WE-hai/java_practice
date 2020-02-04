public class Test {
    private float f = 1.0f;
    int m = 12;
    static int n = 1;
    public static void main (String args[]) {
        Test t = new Test();
        System.out.println(t.m);
        System.out.println(t.f);
        System.out.println(Test.n);
    }
}
