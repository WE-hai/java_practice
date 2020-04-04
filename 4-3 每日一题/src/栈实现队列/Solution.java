package 栈实现队列;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            int sz = stack1.size();
            for(int i = 0;i < sz;i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}