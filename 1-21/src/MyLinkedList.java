public class MyLinkedList {
    public static ListNode partition(ListNode pHead, int x) {
        // 定义两个链表，链表中自带一个结点
        // 该结点没有业务含义
        // 只是为了避免尾插时需要分情况讨论
        ListNode sHead = new ListNode();
        ListNode sLast = sHead;
        ListNode bHead = new ListNode();
        ListNode bLast = bHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.value < x) {
                sLast.next = cur;
                sLast = cur;
            } else {
                bLast.next = cur;
                bLast = cur;
            }
            cur = cur.next;
        }
        // sHead 所代表的链表（第一个结点是无效结点）
        // bHead 所代表的链表（第一个结点是无效结点）
        sLast.next = bHead.next;
        bLast.next = null;

        return sHead.next;
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        ListNode prev = new ListNode();
        ListNode fake = prev;
        prev.next = pHead;
        ListNode cur = pHead;
        ListNode next = pHead.next;

        while (next != null) {
            if (cur.value != next.value) {
                prev = prev.next;
                cur = cur.next;
                next = next.next;
            } else {
                while (next != null && cur.value== next.value) {
                    next = next.next;
                }
                // next 可能是 null
                // 删除 [cur, next)
                prev.next = next;

                cur = next;
                if (next != null) {
                    next = next.next;
                }
            }
        }

        return fake.next;
    }

    public int getLength(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        return count;
    }
    public ListNode getMiddle(ListNode head) {
        int length = getLength(head);
        int half = length / 2;
        ListNode cur = head;
        for (int i = 0; i < half; i++) {
            cur = cur.next;
        }

        return cur;
    }

    public ListNode reverseList(ListNode head) {
        ListNode nHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = nHead;
            nHead = cur;

            cur = next;
        }

        return nHead;
    }
    public boolean chkPalindrome(ListNode A) {
        ListNode middle = getMiddle(A);
        ListNode rHead = reverseList(middle);
        ListNode c1 = A;
        ListNode c2 = rHead;

        while (c1 != null && c2 != null) {
            if (c1.value != c2.value) {
                return false;
            }

            c1 = c1.next;
            c2 = c2.next;
        }

        return true;
    }
}
