package 反转链表;

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null; // 当前节点的前一个节点
        ListNode next = null; // 当前节点的下一个节点
        while(head != null){
            next = head.next; // 记录当前节点的下一个节点位置；
            head.next = prev; // 让当前节点指向前一个节点位置，完成反转
            prev = head;     // prev 往右走
            head = next;    // 当前节点往右继续走
        }
        return prev;
    }
}
