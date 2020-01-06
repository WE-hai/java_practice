public class BinaryTree {
    public static int size = 0;
    public static int leafSize = 0;

    public void getSize1(Node root) {
        if (root != null) {
            getSize1(root.left);
            getSize1(root.right);
            size++;
        }
    }

    public int getSize2(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right ==null) {
            return 1;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    public void getLeafSize1(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
            return;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    public int getLeafSize2(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    public int getKSize(Node root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKSize(root.left,k-1) + getKSize(root.right,k-1);
    }
}
