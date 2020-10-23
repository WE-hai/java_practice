package 包含min函数的栈;

import java.util.Stack;

public class Solution {
    //需要这样写来初始化stack，不然会报空指针push的时候
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Integer minElement = Integer.MAX_VALUE;

    public void push(int node) {
        if(stack.empty()) {
            minElement = node;
            stack.push(node);
        } else {
            if(node <= minElement){
                stack.push(minElement);//在push更小的值时需要保留在此值之前的最小值
                minElement = node;
            }
            stack.push(node);
        }
    }

    public void pop() {
        //增加最后一个元素以及栈为空时候的检测
        if(stack.size() == 0)return;
        if( minElement == stack.peek()){
            if(stack.size() >1){
                stack.pop();
                minElement = stack.peek();
            }else{
                minElement = Integer.MAX_VALUE;
            }

        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minElement;
    }
}
