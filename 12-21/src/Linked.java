public class Linked {
    private Node head;
    private int size;

    public Linked(){
        head = null;
        size = 0;
    }

    public void pushFront(int val) {
        head = new Node(val,head);
        size++;
    }

    public void popFront(){
        if (size == 0) {
            throw new RuntimeException("kong");
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
            throw new RuntimeException("kong");
        }
        if (head.next == null) {
            head = null;
        } else {
            Node preLast = head;
            while (preLast.next.next == null) {
                preLast = preLast.next;
            }
            preLast.next = null;
        }
        size--;
    }
}
