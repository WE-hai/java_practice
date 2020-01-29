public class Main {
    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildTree();
        BinaryTree.leverOrder(root);
        System.out.println();
        System.out.println(BinaryTree.isCompleteTree(root));
        TreeNode root2 = BinaryTree.buildTree2();
        BinaryTree.leverOrder(root2);
        System.out.println();
        System.out.println(BinaryTree.isCompleteTree(root2));

    }
}
