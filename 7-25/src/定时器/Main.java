package 定时器;

import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    private static class TimerTask implements Comparable<TimerTask> {
        private Runnable command;
        private long time;
        private TimerTask(Runnable command, long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }
        private void run() {
            command.run()
            ;
        }

        @Override
        public int compareTo(TimerTask o) {
            return (int)(time - o.time);
        }
    }
    private PriorityBlockingQueue<TimerTask> queue = new PriorityBlockingQueue<>();
    private Object mailbox = new Object();
    private class Worker extends Thread {
        @Override public void run() {
            while (true) {
                try {
                    TimerTask task = queue.take();
                    long ms = System.currentTimeMillis();
                    if (task.time > ms) {
                        queue.put(task);
                        synchronized (mailbox) {
                            mailbox.wait(task.time - ms);
                        }
                    } else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
    public Main() {
        Worker worker = new Worker();
        worker.start();
    }

    public void schedule(Runnable command, long after) {
        TimerTask task = new TimerTask(command, after);
        queue.offer(task);
        synchronized (mailbox) {
            mailbox.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main timer = new Main();
        Runnable command = new Runnable() {
            @Override
            public void run() {
                System.out.println("我来了");
                timer.schedule(this, 3 * 1000);
            }
        };
        timer.schedule(command, 3 * 1000);
    }
}

