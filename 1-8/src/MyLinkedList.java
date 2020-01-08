public class MyLinkedList {
    public Node pushFront(Node head,int value) {
        Node node = new Node(value);
        node.next = head;
        return node;
    }

    public Node popFront(Node head) {
        if (head == null) {
            throw new RuntimeException("kong");
        }
        return head.next;
    }

    public Node pushBack(Node head,int value) {
        Node node = new Node(value);
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

    public Node popBack(Node head) {
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

    public Node buildLinkedList() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }
}
