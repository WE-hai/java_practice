package 链表中倒数第k个结点;

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0 ){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0;i < k;i++){
            if(fast == null){
                return null;
            }
            fast = fast.next;

        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
