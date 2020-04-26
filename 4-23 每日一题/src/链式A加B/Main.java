package 链式A加B;

public class Main {
    public static ListNode plusAB(ListNode a,ListNode b) {
        if (a == null || b == null) {
            return null;
        }
        ListNode curA = a;
        ListNode curB = b;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int add = 0;
        while (curA != null || curB != null) {
            if (curA != null) {
                add += curA.val;
                curA = curA.next;
            }
            if (curB != null) {
                add += curB.val;
                curB = curB.next;
            }
            cur.next = new ListNode(add%10);
            add /= 10;
            cur = cur.next;
        }
        return head.next;
    }

    public static void print(ListNode node) {
        ListNode cur = node;
        while (node != null) {
            System.out.print(node.val+" ");
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(1);
        a.next = a1;
        a1.next = a2;
        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(3);
        b.next = b1;
        b1.next = b2;
        print(plusAB(a,b));
    }
}
