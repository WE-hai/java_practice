public class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    //尾插
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
    //尾删
    public void popBack() {
        if (size == 0) {
            throw new RuntimeException("空链表");
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
//头插
    public void pushFront(int val) {
        head = new Node(val,head);
        size++;
    }
    //头删
    public void popFront() {
        if (size == 0) {
            throw new RuntimeException("空链表");
        }
        head = head.next;
        size--;
    }

    //打印
    public void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
