public class Main {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        TreeNode root = bTree.buildTree();
        bTree.preOrder(root);
        System.out.println();
        bTree.inOrder(root);
        System.out.println();
        bTree.postOrder(root);
        System.out.println();
        bTree.getSize1(root);
        System.out.println(BinaryTree.size);
        System.out.println(bTree.getSize2(root));
        bTree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);
        System.out.println(bTree.getLeafSize2(root));
        System.out.println(bTree.getKSize(root, 1));
        System.out.println(bTree.getKSize(root, 2));
        System.out.println();
        System.out.println(bTree.getKSize(root, 3));
        System.out.println(bTree.getKSize(root, 4));
    }
}
