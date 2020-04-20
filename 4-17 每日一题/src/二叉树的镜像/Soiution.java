package 二叉树的镜像;

public class Soiution {
    public void mirror(TreeNode root) {
        TreeNode tmp = null;
        if (root != null) {
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.left != null) {
                mirror(root.left);
            }
            if (root.right != null) {
                mirror(root.right);
            }
        }
    }
}
