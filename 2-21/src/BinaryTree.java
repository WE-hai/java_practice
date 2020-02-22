import java.util.*;

public class BinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ret.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right !=null) {
                    queue.add(node.right);
                }
            }
        }
        return ret;
    }

    public static TreeNode buildTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n4.right = n7;
        n5.right = n8;
        return n1;
    }
    public static void main(String[] args) {
        BinaryTree test = new BinaryTree();
        TreeNode root = buildTree();
        List<Integer> list = test.rightSideView(root);
        System.out.println(list);
    }
}
