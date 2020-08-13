public class Test1 {
    public static int a = 1;
    public static void main(String[] args) {
        int a = 10;
        a++;
        Test1.a++;
        Test1 t = new Test1();
        System.out.println("a = " + a + " t.a = " + t.a);
    }
}
