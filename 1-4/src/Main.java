class Node {
    int value;
    Node next;
}
class Queue {
    Node front;
    Node rear;
    int size;

    public Queue() {
        //空队列
        front = rear = null;
        size = 0;
    }

    public void offer(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;
        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
        size++;
    }

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

    public int peek() {
        if (front == null) {
            return -1;
        }
        return front.value;
    }

    public int rear() {
        if (front == null) {
            return -1;
        }
        return front.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
        //return front == null;
    }
}
public class Main {

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        System.out.println();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);;
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        System.out.println();
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.poll();
        }
        System.out.println(q.isEmpty());
        System.out.println(q.size());
    }
}
