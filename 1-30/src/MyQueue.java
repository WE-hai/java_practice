import java.util.Stack;

public class MyQueue {
    Stack<Integer> pushSt;
    Stack<Integer> popSt;

    public MyQueue() {
        pushSt = new Stack<>();
        popSt = new Stack<>();
    }

    public void push(int x) {
        pushSt.push(x);
    }

    public int pop() {
        if(popSt.isEmpty()){
            int sz = pushSt.size();
            for(int i = 0; i < sz; ++i){
                popSt.push(pushSt.pop());
            }
        }
        return popSt.pop();
    }

    public int peek() {
        if(popSt.isEmpty()){
            int sz = pushSt.size();
            for(int i = 0; i < sz; ++i){
                popSt.push(pushSt.pop());
            }
        }
        return popSt.peek();
    }

    public boolean empty() {
        return pushSt.isEmpty() && popSt.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println(queue.empty());
        System.out.println(queue.peek());
        queue.pop();
        queue.pop();
        System.out.println(queue.empty());
        System.out.println(queue.peek());
    }
}

