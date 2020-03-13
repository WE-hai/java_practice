import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    //前序遍历
    public void preOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !st.isEmpty()) {
            while (curNode != null) {
                System.out.print(curNode.value+" ");
                st.push(curNode);
                curNode = curNode.left;
            }
            curNode = st.pop();
            curNode = curNode.right;
        }
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !st.isEmpty()) {
            while (curNode != null) {
                st.push(curNode);
                curNode = curNode.left;
            }
            curNode = st.pop();
            System.out.print(curNode.value+" ");
            curNode = curNode.right;
        }
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curNode = root;
        TreeNode prev = null;
        while (curNode != null || !st.isEmpty()) {
            while (curNode != null) {
                st.push(curNode);
                curNode = curNode.left;
            }
            curNode = st.peek();
            if (curNode.right == null || curNode.right == prev) {
                System.out.print(curNode.value+" ");
                prev = curNode;
                st.pop();
                curNode = null;
            } else {
                curNode = curNode.right;
            }
        }
    }

    //层序遍历
    public void leverOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            //获取队头元素
            TreeNode topNode = queue.poll();
            System.out.print(topNode.value+" ");
            //入队孩子节点
            if(topNode.left != null) {
                queue.offer(topNode.left);
            }
            if(topNode.right != null) {
                queue.offer(topNode.right);
            }
        }
    }
}
