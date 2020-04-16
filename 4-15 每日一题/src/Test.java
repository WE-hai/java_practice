public class Test {
    private float f = 1.0f;
    static int n = 1;
    int m = 12;
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(Test.n);
        System.out.println(t.f);
        System.out.println(t.m);
        System.out.println();
        A a = new A("he");
        A b = new A("he");
        System.out.println(a == b);
    }
}
class A {
    public A(String s) {

    }
}