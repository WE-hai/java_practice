public class Main extends MyLinkedList{
    public static void print(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Main LinkedList = new Main();
        Node head = LinkedList.buildLinkedList();
        print(head);
        System.out.println();
        LinkedList.pushFront(head,0);
        LinkedList.pushBack(head,7);
        LinkedList.pushBack(head,8);
        print(head);
        System.out.println();
        LinkedList.popFront(head);
        LinkedList.popBack(head);
        print(head);
    }
}
