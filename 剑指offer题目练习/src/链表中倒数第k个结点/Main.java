package 链表中倒数第k个结点;

public class Main {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        cur = head;
        int i = 1;
        while (cur != null && i != len-k+1) {
            i++;
            cur = cur.next;
        }
        return cur;
    }
}
