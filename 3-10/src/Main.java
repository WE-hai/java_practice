public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6= new TreeNode(5);
        root.left = n1;
        root.right = n4;
        n1.left = n2;
        n4.left = n3;
        n1.right = n5;
        n3.right = n6;
        BinaryTree btree = new BinaryTree();
        System.out.print("前序遍历：");
        btree.preOrder(root);
        System.out.println();
        System.out.print("中序遍历：");
        btree.inOrder(root);
        System.out.println();
        System.out.print("后序遍历：");
        btree.postOrder(root);
    }
}
