package 水滴1;

public class Solution {
    public ListNode removeKNode(ListNode head,int k) {
        ListNode cur = head;
        int i = 0;
        for (i = 0;i < k;i++) {
            cur = cur.next;
            if (cur == null) {
                break;
            }
        }
        if (i == k-1 && cur == null) {
            return head.next;
        }
        if (i < k-1 && cur == null) {
            return head;
        }
        ListNode node = head;
        while (cur.next != null) {
            cur = cur.next;
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
}