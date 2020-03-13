public class Main {
    public static TreeNode buildTree(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = left;
        root.right = right;
        left.left = node4;
        left.right = node5;
        right.left = node6;
        right.right = node7;
        left.left.left = node8;
        return root;
    }

    public static void main(String[] args) {
        BinaryTree btree = new BinaryTree();
        TreeNode root = buildTree();
        System.out.print("前序遍历：");
        btree.preOrder(root);
        System.out.println();
        System.out.print("中序遍历：");
        btree.inOrder(root);
        System.out.println();
        System.out.print("后序遍历：");
        btree.postOrder(root);
        System.out.println();
        System.out.print("层序遍历：");
        btree.leverOrder(root);
    }
}
