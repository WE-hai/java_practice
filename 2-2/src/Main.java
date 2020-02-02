class Node {
    char value;
    Node left;
    Node right;

    Node(char value) {
        this.value = value;
    }
}
public class Main {
    public static int size;
    public static int leafSize = 0;

    //private Node root = null;
    public static Node buildTree() {
        Node root = new Node('A');
        Node node1 = new Node('B');
        Node node2 = new Node('C');
        Node node3 = new Node('D');
        Node node4 = new Node('E');
        Node node5 = new Node('F');
        Node node6 = new Node('G');
        Node node7 = new Node('H');
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.right = node7;

        return root;
    }

    public static void pre(Node root) {  //前序遍历：根左右
        //终止条件:null空树
        if (root == null) {
            return;
        } else {
            System.out.print(root.value + " ");   //根
            pre(root.left);   //左
            pre(root.right);   //右
        }
    }

    public static void mid(Node root) {
        if (root != null) {
            mid(root.left);
            System.out.print(root.value + " ");
            mid(root.right);
        }
    }

    public static void back(Node root) {
        if (root != null) {
            back(root.left);
            back(root.right);
            System.out.print(root.value + " ");
        }
    }

    public void getSize1(Node root) {
        if (root == null) {
            return;
        } else {
            size++;
            getSize1(root.left);
            getSize1(root.right);
        }
    }

    public static int getSize2(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    public void getLeafSize1(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ++leafSize;
            return;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    public static int getLeafSize2(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    public static int getkSize(Node root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getkSize(root.left, k - 1) + getkSize(root.right, k - 1);
    }

    public static void main(String[] args) {
        Main tree = new Main();
        Node root = buildTree();
        pre(root);
        System.out.println();
        mid(root);
        System.out.println();
        back(root);
        System.out.println();
        tree.getSize1(root);
        System.out.println(getSize2(root));
        System.out.println(Main.size);
        tree.getLeafSize1(root);
        System.out.println(Main.leafSize);
        System.out.println(getLeafSize2(root));
        System.out.println(getkSize(root, 2));
    }
}