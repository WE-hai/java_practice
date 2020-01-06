public class Test extends BinaryTree{
    public Node buildTree() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        root.left = node1;
        root.right = node3;
        node1.left = node2;
        node1.right = node4;
        node3.left = node5;
        node4.right = node6;
        return root;
    }

    public static void main(String[] args) {
        Test bTree = new Test();
        Node root = bTree.buildTree();
        bTree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);
        bTree.getLeafSize2(root);
        System.out.println(BinaryTree.leafSize);
        bTree.getSize1(root);
        System.out.println(BinaryTree.size);
        bTree.getSize2(root);
        System.out.println(BinaryTree.size);
        System.out.println(BinaryTree.leafSize);
        System.out.println(BinaryTree.size);
        System.out.println(bTree.getKSize(root,2));
    }
}
