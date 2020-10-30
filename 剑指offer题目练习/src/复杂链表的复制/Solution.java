package 复杂链表的复制;

import java.util.HashMap;

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        // target 作为将要返回的头，记住要new的
        RandomListNode target = new RandomListNode(pHead.label);
        // cur 获取链表头
        RandomListNode cur = pHead;
        // p   获取新链表头
        RandomListNode p = target;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        // 由pHead将所有值存入map，每一个结点都要new的
        while (pHead != null) {
            map.put(pHead, new RandomListNode(pHead.label));
            pHead = pHead.next;
        }

        // target作为新链表的头，由cur，p移动来复制链表
        while (cur != null) {
            p.next = map.get( cur.next );
            p.random = map.get( cur.random );

            cur = cur.next;
            p = p.next;
        }
        return target;
    }
}
