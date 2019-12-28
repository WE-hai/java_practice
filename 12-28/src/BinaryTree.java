import java.util.*;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int value;
    public TreeNode(int value){
        this.value = value;
    }
}
/*
public class BinaryTree {
    public Node find(Node root, int value){
        if(root == null)
            return root;
        if(root.value == value)
            return root;
        Node node = find(root.left, value);
        if(node != null)
            return node;
        return find(root.right, value);
    }
}
*/

/*
class Solution {
    public void _preOrder(TreeNode root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            _preOrder(root.left, list);
            _preOrder(root.right, list);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        _preOrder(root, list);
        return list;
    }
}
*/
/*
class Solution {
    public void _inOrder(TreeNode root, List<Integer> list){
        if(root != null){
            _inOrder(root.left, list);
            list.add(root.value);
            _inOrder(root.right, list);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        _inOrder(root, list);
        return list;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return false;
        if(isSameTree(s, t))
            return true;
        if(isSubtree(s.left, t))
            return true;
        return isSubtree(s.right, t);
    }
}

class Solution {
    public int getHeight(TreeNode root){
        return root == null ? 0 : Math.max(getHeight(root.left)
                , getHeight(root.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left - right) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
*/
public class BinaryTree{
    public static void leverOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.offer(root);
        while(!queue.isEmpty()){
            //获取队头元素
            TreeNode topNode = queue.poll();
            System.out.print(topNode.value);
            //入队孩子节点
            if(topNode.left != null){
                queue.offer(topNode.left);
            }
            if(topNode.right != null){
                queue.offer(topNode.right);
            }
        }
    }

    public  static boolean  isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode topNode = queue.poll();
            //遇到第一个null节点，停止层序遍历
            if(topNode == null)
                break;
            queue.offer(topNode.left);
            queue.offer(topNode.right);
        }
        //剩余全部出队， 如果有非空节点，说明不是完全二叉树
        while(!queue.isEmpty()){
            TreeNode topNode = queue.poll();
            if(topNode != null)
                return false;
        }
        return true;
    }

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

    public static TreeNode buildTree2(){
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
        left.left.right = node8;
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = buildTree();
        leverOrder(root);
        System.out.println(isCompleteTree(root));
        TreeNode root2 = buildTree2();
        leverOrder(root2);
        System.out.println(isCompleteTree(root2));

    }
}