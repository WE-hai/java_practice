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
}
