import java.util.Stack;

public class MyQueue {
    Stack<Integer> pushSt;
    Stack<Integer> popSt;
    //两个栈，来实现队列
    public MyQueue() {
        pushSt = new Stack<>();
        popSt = new Stack<>();
    }

    //入队
    public void push(int val) {
        pushSt.push(val);
    }

    //出队
    public int pop() {
        if (popSt.isEmpty()) {
            for (int i = 0;i < pushSt.size();i++) {
                popSt.push(pushSt.pop());
            }
        }
        return popSt.pop();
    }

    //取栈顶元素
    public int peek() {
        if (popSt.isEmpty()) {
            for (int i = 0;i < pushSt.size();i++) {
                popSt.push(pushSt.pop());
            }
        }
        return popSt.peek();
    }

    //判断是否为空
    public boolean empty() {
        return pushSt.isEmpty() && popSt.isEmpty();
    }
 }
