public class Main {      //简单链表
    public static void main(String[] args) {
        ListNode head = null;
        ListNode node;
        // 就地头插 1
        node = new ListNode();
        node.val = 1;
        node.next = head;
        head = node;

        // 就地打印
        for (ListNode c = head; c != null; c = c.next) {
            System.out.println(c.val);
        }

        // 就地尾插 2
        // 尾插（空链表 or 非空链表)
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new ListNode();
        last.next.val = 2;

        // 就地打印
        for (ListNode c = head; c != null; c = c.next) {
            System.out.println(c.val);
        }

        // 就地复制
        ListNode result = null;
        ListNode resultLast = null;
        for (ListNode c = head; c != null; c = c.next) {
            ListNode newNode = new ListNode();
            newNode.val = c.val;
            if (result == null) {
                result = newNode;
            } else {
                resultLast.next = newNode;
            }
            resultLast = newNode;
        }

        // 就地打印
        for (ListNode c = result; c != null; c = c.next) {
            System.out.println(c.val);
        }
    }
}
