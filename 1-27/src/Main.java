public class Main {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.pushFront(1);
        linkedList.pushFront(2);
        linkedList.pushFront(3);
        linkedList.pushFront(4);
        linkedList.pushFront(5);
        System.out.println("头结点：");
        System.out.println(linkedList.head.value);
        System.out.println("链表长度：");
        System.out.println(linkedList.size);
        linkedList.pushFront(0);
        linkedList.pushBack(6);
        linkedList.pushBack(7);
        linkedList.pushBack(8);
        System.out.println("头结点：");
        System.out.println(linkedList.head.value);
        System.out.println("链表长度：");
        System.out.println(linkedList.size);
        linkedList.popBack();
        System.out.println("头结点：");
        System.out.println(linkedList.head.value);
        System.out.println("链表长度：");
        System.out.println(linkedList.size);
        linkedList.popFront();
        System.out.println("头结点：");
        System.out.println(linkedList.head.value);
        System.out.println("链表长度：");
        System.out.println(linkedList.size);
    }
}
