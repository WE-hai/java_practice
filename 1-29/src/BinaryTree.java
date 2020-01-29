import java.util.LinkedList;
import java.util.Queue;

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
}
