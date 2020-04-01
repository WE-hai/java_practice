package 括号串;

import java.util.Stack;

public class Main {
    public boolean chkParenthesis(String A, int n) {
        if (n == 0 || A.length() != n) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] arr = A.toCharArray();
        for (int i = 0;i < arr.length;i++) {
            if (arr[i] != '(' && arr[i] != ')') {
                return false;
            }
            if (arr[i] == '(') {
                stack.push(arr[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (arr[i] == ')'){
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
