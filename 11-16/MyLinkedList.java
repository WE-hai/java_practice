package doubly_list;

public class MyLinkedList {
    private Node head = null;
    private Node last = null;
    private int size = 0;

    public void pushFront(int val) {
        Node node = new Node(val);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (head.next == null) {
            last = head;
        }

        size++;
    }

    public void popFront() {
        if (size == 0) {
            throw new RuntimeException("空的");
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            last = null;
        }
        size--;
    }

    public void pushBack(int val) {
        Node node = new Node(val);
        if (last != null) {
            last.next = node;
        } else {
            head = node;
        }
        node.prev = last;
        last = node;

        size++;
    }

    public void popBack() {
        if (size == 0) {
            throw new RuntimeException("空的");
        }

        if (last.prev != null) {
            last.prev.next = null;
            last = last.prev;
        } else {
            head = last = null;
        }

        size--;
    }

    public void reset() {
        head = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        // "1 --> 2 --> null"
        String s = "";
        for (Node cur = head; cur != null; cur = cur.next) {
            s += String.format("%d --> ", cur.val);
        }
        s += "null";

        return s;
    }
}
