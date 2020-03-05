class Node {
    int value;
    Node next;
}

public class Queue {
    Node front;
    Node rear;
    int size;

    public Queue() {
        front = rear = null;
        size = 0;
    }

    //入队
    public void offer(int val) {
        Node node = new Node();
        node.value = val;
        node.next = null;
        if (front == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = rear.next;
        }
        size++;
    }

    //出队
    public void poll() {
        if (front == null) {
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
    }

    //取队顶元素
    public int peek() {
        if (front == null) {
            return -1;
        }
        return front.value;
    }

    //取队尾元素
    public int rear() {
        if (front == null) {
            return -1;
        }
        return rear.value;
    }

    //队列长度
    public int size() {
        return size;
    }

    //判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }
}
