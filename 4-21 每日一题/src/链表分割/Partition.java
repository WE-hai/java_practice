package 链表分割;

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode node = new ListNode(x);
        ListNode newHead = new ListNode(0);
        newHead.next = node;
        ListNode front = newHead;
        ListNode rear = node;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val < x) {
                ListNode n = new ListNode(cur.val);
                front.next = n;
                n.next = node;
                front = n;
            } else if (cur.val >= x) {
                ListNode n = new ListNode(cur.val);
                rear.next = n;
                rear = n;
            }
            cur = cur.next;
        }
        front.next = node.next;
        return newHead.next;
    }
}
