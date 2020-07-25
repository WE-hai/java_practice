public class ThreadStateTransfer {
    //关注 WAITING 、 BLOCKED 、 TIMED_WAITING 状态的转换
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread t = new Thread(() -> {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 1000_0000; i++) {

                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        Thread.sleep(10);
        synchronized (object) {
            for (int i = 0; i < 10; i++) {
                System.out.println(t.getState());
            }
            object.notify();
        }
        while (t.isAlive()) {
            System.out.println(t.getState());
        }
    }
}
