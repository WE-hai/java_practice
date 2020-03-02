public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.pushFront(1);
        list.pushFront(3);
        list.pushBack(6);
        list.pushBack(8);
        list.pushFront(4);
        list.pushFront(7);
        list.pushBack(2);
        list.pushBack(9);
        System.out.print("链表长度："+list.size+"  ");
        System.out.println("头结点："+list.head.value);
        System.out.print("链表：");
        list.printList(list.head);
        System.out.println();
        list.popFront();
        list.popBack();
        System.out.print("链表长度："+list.size+"  ");
        System.out.println("头结点："+list.head.value);
        System.out.print("链表：");
        list.printList(list.head);
        System.out.println();

        BinaryTree btree = new BinaryTree();
        TreeNode root = btree.buildTree();
        System.out.print("前序遍历：");
        btree.preOrder(root);
        System.out.println();
        System.out.print("中序遍历：");
        btree.inOrder(root);
        System.out.println();
        System.out.print("后序遍历：");
        btree.postOrder(root);
    }
}
