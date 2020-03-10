public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        value = 0;
        left = null;
        right = null;
    }

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}
