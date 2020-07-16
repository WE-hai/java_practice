public class ThreadAdvantage {
    private static final long count = 10_0000_0000;

    private static void concurrency() throws InterruptedException {
        long begin = System.nanoTime();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0;i < count;i++) {
                    a--;
                }
            }
        });
        thread.start();

        int b = 0;
        for (int i = 0;i < count;i++) {
            b--;
        }
        thread.join();
        long end = System.nanoTime();
        double ms = (end-begin)*1.0/1000/1000;
        System.out.printf("并发：%f 毫秒\n",ms);
    }

    private static void serial() {
        long begin = System.nanoTime();
        int a = 0;
        for (long i = 0;i < count;i++) {
            a--;
        }
        int b = 0;
        for (long i = 0;i < count;i++) {
            b--;
        }
        long end = System.nanoTime();
        double ms = (end-begin)*1.0/1000/1000;
        System.out.printf("串行：%f 毫秒\n",ms);
    }
    public static void main(String[] args) throws InterruptedException {
        //并发方式
        concurrency();
        //串行方式
        serial();
    }
}
