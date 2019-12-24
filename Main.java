package doubly_list;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        list.pushFront(4);
        System.out.println(list);
        list.reset();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        System.out.println(list);
        list.popFront();
        list.popFront();
        list.popFront();
        System.out.println(list);
        list.popFront();
        System.out.println(list);
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        System.out.println(list);
        list.popBack();
        list.popBack();
        list.popBack();
        System.out.println(list);
        list.popBack();
        System.out.println(list);
        list.popBack();
    }
}
