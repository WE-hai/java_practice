import java.util.Arrays;

public class MyStack {
    private int[] array;
    private int size;

    public MyStack(int n) {
        array = new int[n];
        size = 0;
    }

    public void push(int value) {
        if (size == array.length) {
            array = Arrays.copyOf(array,2*size);
        }
        array[size++] = value;
    }

    public void pop() {
        if (size > 0) {
            size--;
        }
    }

    public int peek() {
        return array[size-1];
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }
    public static void main(String[] args) {
        MyStack stack = new MyStack(3);
        System.out.println(stack.size());
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.size());
        System.out.println(stack.empty());
        System.out.println("栈顶：" +stack.peek());
        System.out.println("遍历：");
        while (!stack.empty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
        System.out.println();
        System.out.println(stack.size());
        System.out.println(stack.empty());
    }
}
