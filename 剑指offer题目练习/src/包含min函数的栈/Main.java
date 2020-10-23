package 包含min函数的栈;

import java.util.Stack;

public class Main {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stackMin = new Stack<Integer>();

    public void push(int node) {
        stack.push(node);
        if (stackMin.empty()) {
            stackMin.push(node);
        } else if (stackMin.peek() >= node) {
            stackMin.push(node);
        }
    }

    public void pop() {
        if (stack.peek() == stackMin.peek()) {
            stackMin.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
