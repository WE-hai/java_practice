class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Main {

    public void preOrder(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }

    public Node buildTree() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.right = node5;
        return root;
    }
    public static void main(String[] args) {
        Main bTree = new Main();
        Node root = bTree.buildTree();
        System.out.println("前序遍历：");
        bTree.preOrder(root);
        System.out.println("中序遍历：");
        bTree.inOrder(root);
        System.out.println("后序遍历：");
        bTree.postOrder(root);
    }
}
