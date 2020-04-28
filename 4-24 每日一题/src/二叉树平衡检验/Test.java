package 二叉树平衡检验;

public class Test {
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root==null)
            return true;
        if(Math.abs(deepth(root.left)-deepth(root.right))>1)
            return false;
        else
            return isBalance(root.left)&isBalance(root.right);
    }
    public int deepth(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(deepth(root.left),deepth(root.right))+1;
    }

}
