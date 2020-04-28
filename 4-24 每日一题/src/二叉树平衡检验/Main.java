package 二叉树平衡检验;

public class Main {
    public int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDeep(root.left),getDeep(root.right))+1;
    }
    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int left = getDeep(root.left);
            int right = getDeep(root.right);
            if (Math.abs(left-right) > 1) {
                return false;
            } else {
                return isBalance(root.left) && isBalance(root.right);
            }
        }
    }
}
