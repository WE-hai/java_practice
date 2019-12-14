class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        next = null;
    }

    public Node(int val,Node next) {
        this.val = val;
        this.next = next;
    }
}

public class MyLinkedList {
    private int size;
    private Node head;

    public MyLinkedList() {
        size = 0;
        head = null;
    }
    //头插  O(1)
    public void pushFront(int val) {
        head = new Node(val,head);
        size++;
    }
    //头删  O(1)
    public void popFront() {
        if (size == 0) {
            throw new RuntimeException("空链表");
        }
        head = head.next;
        size--;
    }
    //尾插
    public void pushBack(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
        size++;
    }
    //尾删
    public void popBack() {
        if (size == 0) {
            throw new RuntimeException("空链表");
        }
        if (head.next == null) {
            head = null;
        } else {
            Node preLast = head;
            while (preLast.next.next != null) {
                preLast = preLast.next;
            }
            preLast.next = null;
        }
        size--;
    }

    public static Node buildLinkedList() {
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return head;
    }

    public static void main(String[] args) {

    }
}
