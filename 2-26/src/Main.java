public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree();
        System.out.println("前序遍历：");
        System.out.println("递归：");
        tree.preOrder(root);
        System.out.println();
        System.out.println("非递归：");
        tree.prevOrder(root);
        System.out.println();
        System.out.println("中序遍历：");
        System.out.println("递归：");
        tree.inOrder(root);
        System.out.println();
        System.out.println("非递归：");
        tree.midOrder(root);
        System.out.println();
        System.out.println("后序遍历：");
        System.out.println("递归：");
        tree.backOrder(root);
        System.out.println();
        System.out.println("非递归：");
        tree.postOrder(root);
    }
}
