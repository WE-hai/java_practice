public class BinaryTree {
    static int size = 0;
    static int leafSize = 0;
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }
    }

    public void getSize1(TreeNode root){
        if(root != null){
            //左子树
            getSize1(root.left);
            //右子树
            getSize1(root.right);
            //根
            ++size;
        }
    }


    public int getSize2(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        //整棵树节点： 当前节点 + 左右子树节点的个数
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    public void getLeafSize1(TreeNode root){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            ++leafSize;
            return;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 子问题思路-求叶子结点个数
    // 整棵树的叶子 = 左右子树的叶子之和
    public int getLeafSize2(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    public int getKSize(TreeNode root, int k){
        if(root == null)
            return 0;
        if(k == 1)
            return 1;
        return getKSize(root.left, k - 1) + getKSize(root.right, k - 1);
    }
    public TreeNode buildTree(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.right = node7;
        return root;
    }
}
