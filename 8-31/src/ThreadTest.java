public class ThreadTest extends Thread {

    int a = 2, b = 0, c = 0;
    public void f1() {
        b = a * 2;
        a = b;
        System.out.println(a);
    }
    public void f2() {
        c = a + 11;
        a = c;
        System.out.println(a);
    }

    @Override
    public void run() {
        f1();
        f2();
    }
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        t1.start();
        t2.start();
    }
}
