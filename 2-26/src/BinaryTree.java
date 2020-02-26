import java.util.Stack;

public class BinaryTree {
    //递归遍历
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
    public void backOrder(TreeNode root) {
        if (root != null) {
            backOrder(root.left);
            backOrder(root.right);
            System.out.print(root.value+" ");
        }
    }

    //非递归实现
    //前序遍历
    public void prevOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                System.out.print(curNode.value+" ");
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            curNode = curNode.right;
        }
    }

    //中序遍历
    public void midOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            System.out.print(curNode.value+" ");
            curNode = curNode.right;
        }
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        TreeNode prev = null;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.peek();
            if (curNode.right == null || curNode.right == prev) {
                System.out.print(curNode.value+" ");
                prev = curNode;
                stack.pop();
                curNode = null;
            } else {
                curNode = curNode.right;
            }
        }
    }

    //建树
    public TreeNode buildTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.right = n8;
        n5.left = n9;
        n5.right = n10;
        n7.left = n11;
        return n1;
    }
}
