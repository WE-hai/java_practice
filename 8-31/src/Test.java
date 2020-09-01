public class Test {
    public int x(int n) {
        if(n <= 3) {
            return 1;
        } else {
            System.out.println(x(n - 2) + x(n - 4) + 1);
            return x(n - 2) + x(n - 4) + 1;
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.x(8);
    }
}
