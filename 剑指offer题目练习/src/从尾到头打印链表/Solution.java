package 从尾到头打印链表;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = listNode;
        while(cur != null) {
            list.add(0,cur.val);
            cur = cur.next;
        }
        return list;
    }
}
