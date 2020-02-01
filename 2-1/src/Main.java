public class Main {
    //链表中，建立的不是链表对像，是结点对象
    public static Node buildLinkedList() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        return n1;
    }

    public static void printLinkedList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static Node pushFront(Node head, int val) {
        Node node = new Node(val);
        node.next = head;
        return node;
    }

    public static Node popFront(Node head) {
        if (head == null) {
            throw new RuntimeException("空");
        }
        return head.next;
    }

    public static void printPartLinkedList(Node head) {
        Node cur;
    }

    //尾插要注意一定要分情况
    public static Node pushBack(Node head, int val) {
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
            throw new RuntimeException("空");
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

    public static void main(String[] args) {
        Node head = buildLinkedList();
        head = pushFront(head, 0);
        head = pushFront(head, 5);
        head = pushBack(head, 1);
        head = pushBack(head, 2);
        head = pushBack(head, 3);
        printLinkedList(head);
    }
}
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        next = null;
    }
}