public class BinaryTree {
    //前序遍历
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.value+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value+" ");
            inOrder(root.right);
        }
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value+" ");
        }
    }
}
