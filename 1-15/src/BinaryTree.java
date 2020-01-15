public class BinaryTree {
    public void preorder(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }

    public void backOrder(TreeNode root) {
        if (root != null) {
            backOrder(root.left);
            backOrder(root.right);
            System.out.println(root.value);
        }
    }
}
