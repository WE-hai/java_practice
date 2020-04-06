public class Test {
    private static int x = 100;
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(Math.round(11.5));
        System.out.println();
        Test t1 = new Test();
        t1.x++;
        Test t2 = new Test();
        t2.x++;
        t1 = new Test();
        t1.x++;
        Test.x--;
        System.out.println(x);
    }
}
