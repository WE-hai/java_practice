package 从上往下打印二叉树;

import java.util.ArrayList;

public class Main {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        bfs(root);
        return list;
    }

    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
        }
        if (root.right != null) {
            list.add(root.left.val);
        }
        bfs(root.left);
        bfs(root.right);
    }
}
