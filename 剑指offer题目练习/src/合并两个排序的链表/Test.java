package 合并两个排序的链表;

public class Test {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode node = new ListNode(0);
        ListNode cur = node;
        while (list1 != null && list2 != null){
            if(list1.val >= list2.val){
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        } else if (list2 != null) {
            cur.next = list2;
        }
        return node.next;
    }
}
