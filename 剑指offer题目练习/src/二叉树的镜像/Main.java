package 二叉树的镜像;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode curr = null;
        TreeNode temp = null;
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int len = nodes.size();
            for(int i = 0; i < len; i++){
                curr = nodes.poll();
                temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                if(curr.left != null) {
                    nodes.offer(curr.left);
                }
                if(curr.right != null) {
                    nodes.offer(curr.right);
                }
            }
        }
    }
}
