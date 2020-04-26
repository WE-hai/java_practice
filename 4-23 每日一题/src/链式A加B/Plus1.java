package 链式A加B;

public class Plus1 {
    public ListNode plusAB(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode p1 = a, p2 = b;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int sum = 0;
        while (p1 != null || p2 != null || sum != 0) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            p.next = new ListNode(sum % 10);
            sum /= 10;
            p = p.next;
        }
        return head.next;
    }
}