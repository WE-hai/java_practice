public class ThreadDemo {
    // yield() 大公无私，让出 CPU
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": 我跑着呢");
                Thread.yield();
            }
        }, "李四");
        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": 我跑着呢");
            }
        }, "王五");
        thread1.start();
        thread2.start();
    }
}
