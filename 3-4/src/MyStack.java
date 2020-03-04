import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int val) {
        queue.offer(val);
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

    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(1);
        st.push(5);
        st.push(6);
        st.push(10);
        st.push(23);
        System.out.println(st.empty());
        System.out.println(st.top());
        st.pop();
        st.pop();
        System.out.println(st.empty());
        System.out.println(st.top());
        st.pop();
        st.pop();
        st.pop();
        System.out.println(st.empty());
        System.out.println(st.top());
    }
}
