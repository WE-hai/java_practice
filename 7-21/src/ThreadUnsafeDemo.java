public class ThreadUnsafeDemo {
    private static class Counter {
        private long n = 0;
        public void increment() {
            n++;
        }
        public void decrement() {
            n--;
        }
        public long value() {
            return n;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int COUNT = 1000_0000;
        Counter counter = new Counter();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                counter.increment();
            }
        }, "李四");
        thread.start();
        for (int i = 0; i < COUNT; i++) {
            counter.decrement();
        }
        thread.join();
        // 期望最终结果应该是 0
        System.out.println(counter.value());
    }
}
