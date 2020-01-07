import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int n) {
        if (queue1.isEmpty()) {
            queue2.offer(n);
        } else {
            queue1.offer(n);
        }
    }

    public int pop() {
        int ret = 0;
        if (queue1.isEmpty()) {
            int sz = queue2.size();
            while (sz > 1) {
                queue1.offer(queue2.poll());
                sz--;
            }
            ret = queue2.poll();
        } else {
            int sz = queue1.size();
            while (sz > 1) {
                queue2.offer(queue1.poll());
                sz--;
            }
            ret = queue1.poll();
        }
        return ret;
    }

    public int top() {
        int ret = pop();
        push(ret);
        return ret;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
