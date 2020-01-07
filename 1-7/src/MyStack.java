import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int n) {
        queue.offer(n);
    }

    public int pop() {
        int sz = queue.size();
        while (sz > 1) {
            queue.offer(queue.poll());
            sz--;
        }
        return queue.poll();
    }

    public int top() {
        int sz = queue.size();
        while (sz > 1) {
            queue.offer(queue.poll());
            sz--;
        }
        int ret = queue.poll();
        queue.offer(ret);
        return ret;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
