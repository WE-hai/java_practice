import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {
         val = x;
     }
}

public class BinaryTree {
    public boolean find(TreeNode root, TreeNode node){
        if(root == null)
            return false;
        if(root == node)
            return true;
        if(find(root.left, node))
            return true;
        return find(root.right, node);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        boolean pL = false, pR = false, qL = false, qR = false;
        //某一个节点为当前树的根
        if(root == p || root == q){
            return root;
        }
        //同一边
        if(find(root.left, p)){
            pL = true;
            pR = false;
        }else{
            pR = true;
            pL = false;
        }
        if(find(root.left, q)){
            qL = true;
            qR = false;
        }else{
            qR = true;
            qL = false;
        }
        //同一边
        if(pL && qL){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(pR && qR){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            //两边
            return root;
        }

    }

    public boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> st){
        if(root == null)
            return false;
        //root入栈
        st.push(root);
        if(root == node)
            //结束
            return true;
        //判断左右子树是否存在node
        if(getPath(root.left, node, st))
            return true;
        if(getPath(root.right, node, st))
            return true;
        //当前root出栈
        st.pop();
        return false;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> path1 = new Stack<>();
        Stack<TreeNode> path2 = new Stack<>();
        getPath(root, p, path1);
        getPath(root, q, path2);
        //裁剪路径
        while(path1.size() != path2.size()){
            if(path1.size() > path2.size()){
                path1.pop();
            }else{
                path2.pop();
            }
        }
        //匹配
        while(path1.size() != 0){
            if(path1.peek() == path2.peek())
                break;
            else{
                path1.pop();
                path2.pop();
            }
        }
        return path1.peek();
    }

    static TreeNode prev = null;
    public void _Convert(TreeNode root){
        if(root == null)
            return;
        //中序遍历
        _Convert(root.left);
        //处理当前节点
        root.left = prev;
        if(prev != null)
            prev.right = root;
        prev = root;
        _Convert(root.right);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        //重置
        prev = null;
        _Convert(pRootOfTree);
        //返回头， 左边的最后一个非空节点
        while(pRootOfTree.left != null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }
    static int curIdx = 0;
    public TreeNode _buildTree(int[] pre, int[] in, int inS, int inE){
        //空树
        if(inS > inE)
            return null;
        int rootValue = pre[curIdx];
        curIdx++;
        TreeNode root = new TreeNode(rootValue);
        //区间中除过根元素，没有孩子节点
        if(inS == inE)
            return root;
        //确定左右子树的区间
        int i;
        for(i = inS; i <= inE; ++i){
            if(in[i] == rootValue)
                break;
        }
        //左右子树的区间：
        //左子树： [inS, i - 1]
        //右子树： [i + 1, inE]
        //构建左右子树
        root.left = _buildTree(pre, in, inS, i - 1);
        root.right = _buildTree(pre, in, i + 1, inE);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //重置
        curIdx = 0;
        return _buildTree(preorder, inorder, 0, preorder.length - 1);
    }

}
