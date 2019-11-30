package single_list;

public class MyLinkedList {
    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // O(1)
    public void pushFront(int val) {
        head = new Node(val, head);
        size++;
    }

    public void popFront() {
        if (size == 0) {
            throw new RuntimeException("空了");
        }

        head = head.next;
        size--;
    }

    public void pushBack(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
        size++;
    }

    public void popBack() {
        if (size == 0) {
            throw new RuntimeException("空的");
        }

        if (head.next == null) {
            head = null;
        } else {
            Node prevLast = head;
            while (prevLast.next.next != null) {
                prevLast = prevLast.next;
            }
            prevLast.next = null;
        }
        size--;
    }
}
