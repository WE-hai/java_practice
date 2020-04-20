public class Test {
    private int count;
    private boolean b;
    Test(int v) {
        count = v;
    }
    public static void main(String[] args) {
        Test test = new Test(88);
        System.out.println(test.count);
        System.out.println(test.b);
    }
}
