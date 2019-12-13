class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}
public class BinaryTree {
    public static int size = 0;
    public static int leafSize = 0;

    public Node buildTree() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;

        return root;
    }

    public void pre(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.val+" ");
            pre(root.left);
            pre(root.right);
        }
    }

    public void mid(Node root) {
        if (root != null) {
            mid(root.left);
            System.out.print(root.val+" ");
            mid(root.right);
        }
    }

    public void back(Node root) {
        if (root != null) {
            back(root.left);
            back(root.right);
            System.out.print(root.val+" ");
        }
    }

    public int getSize1(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        return getSize1(root.left) + getSize1(root.right) + 1;
    }

    public void getSize2(Node root) {
        if (root != null) {
            getSize2(root.left);
            size++;
            getSize2(root.right);
        }
    }

    public int getLeafSize1(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize1(root.left) + getLeafSize1(root.right);
    }

    public void getLeafSize2(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
            return;
        }
        getLeafSize2(root.left);
        getLeafSize2(root.right);
    }

    public int getkSize(Node root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getkSize(root.left,k-1) + getkSize(root.right,k-1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree();
        tree.pre(root);
        System.out.println();
        tree.mid(root);
        System.out.println();
        tree.back(root);
        System.out.println();

        tree.getSize2(root);
        System.out.println(BinaryTree.size);
        System.out.println(tree.getSize1(root));
        tree.getLeafSize2(root);
        System.out.println(BinaryTree.leafSize);
        System.out.println(tree.getLeafSize1(root));
        System.out.println(tree.getkSize(root,4));
    }
}
