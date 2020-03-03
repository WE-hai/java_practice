public class MylinkedList {
    ListNode head = null;
    ListNode last = null;
    int size;

    //头插
    public void pushFront(int val) {
        ListNode node = new ListNode(val);
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

    //头删
    public void popFront() {
        if (size == 0) {
            throw new RuntimeException("空链表");
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            last = null;
        }
        size--;
    }

    //尾插
    public void pushBack(int val) {
        ListNode node = new ListNode(val);
        if (last != null) {
            last.next = node;
        } else {
            head = node;
        }
        node.prev = last;
        last = node;
        size++;
    }

    //尾删
    public void popBack() {
        if (size == 0) {
            throw new RuntimeException("空链表");
        }
        if (last.prev != null) {
            last.prev.next = null;
            last = last.prev;
        } else {
            head = last = null;
        }
        size--;
    }

    //清空
    public void reset() {
        head = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        String s = "";
        for (ListNode cur = head;cur != null;cur = cur.next) {
            s += String.format("%d --->",cur.value);
        }
        s += "null";
        return s;
    }
}
