public class LinkedList {

    public static Node copy(Node head) {
        Node cur = head;
        Node nhead = null;
        Node nlast = null;
        while(cur != null) {
            Node node = new Node(cur.val);
            cur = cur.next;
        }
        return nhead;
    }

    public static RNode copylist(RNode head) {
        if(head == null) {
            return null;
        }
        RNode cur ;
        cur = head;
        while(cur != null) {
            RNode node = new RNode();
            node.val = cur.val;
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        RNode nhead = head.next;
        while(cur != null) {
            RNode node = cur.next;
            cur.next = node.next;
            if(node.next != null) {
                node.next = node.next.next;
            }
            cur = cur.next;
        }
        return nhead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);


    }
}
