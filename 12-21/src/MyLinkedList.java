public class MyLinkedList {
    public static Node pushBack(Node head,int val) {
        Node node = new Node(val);
        if (head == null) {
            return node;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            return head;
        }
    }

    public static Node popBack(Node head) {
        if (head == null) {
            throw new RuntimeException("kong");
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

    public static Node pushFront(Node head,int val) {
        Node node = new Node(val);
        node.next = head;
        return node;
    }

    public static Node popFront(Node head) {
        if (head == null) {
            throw new RuntimeException("kong");
        }
        return head.next;
    }
}
