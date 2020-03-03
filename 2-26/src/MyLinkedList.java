public class MyLinkedList {
    //尾插
    public Node pushBack(Node head, int val) {
        Node node = new Node(val);
        if (head == null) {
            // 链表中没有结点
            return node;
        } else {
            // 链表中至少有一个结点
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            return head;
        }
    }

    // O(n) 尾删
    public static Node popBack(Node head) {
        if (head == null) {
            throw new RuntimeException("空的");
        }
        if (head.next == null) {
            return null;
        } else {
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
            return head;
        }
    }
    //头插
    public static Node pushFront(Node head, int val) {
        Node node = new Node(val);
        node.next = head;
        return node;
    }
    // O(1)   头删
    public static Node popFront(Node head) {
        if (head == null) {
            throw new RuntimeException("空链表");
        }
        return head.next;
    }
}
