import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeWork {
    //二叉树最大宽度
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        q.offer(root);
        list.add(1);
        int res = 1;
        while (!q.isEmpty()) {
            int count = q.size();
            for(int i =count; i> 0; i--) {
                TreeNode cur = q.poll();
                Integer curIndex = list.removeFirst();
                if(cur.left != null) {
                    q.offer(cur.left);
                    list.add(curIndex * 2);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                    list.add(curIndex * 2 +1);
                }
            }
            // list 中 size 为 1 的情况下，宽度也为 1，没有必要计算。
            if(list.size() >= 2) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
            }
        }
        return res;
    }

    //二叉树的完全性检验
    public boolean isCompleteTree(TreeNode root) {
        // 层序遍历
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();  // LinkedList做队列的话支持添加null元素，而ArrayDeque不支持添加null
        queue.add(root);

        boolean flag = false;
        while (!queue.isEmpty()) {
            int curCount = queue.size();
            for (int i = 0; i < curCount; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    if (flag) return false;  // 如果在这之前出现过null节点，根据完全二叉树的性质，可以判断结果了
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                }else{ // 记录出现过null节点
                    flag = true;
                }
            }
        }
        return true;
    }

    //递增顺序查找树
    public void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        TreeNode resultRoot = list.get(0);
        TreeNode tmp = resultRoot;
        for (int i = 1; i < list.size(); i++) {
            tmp.right = list.get(i);
            tmp.left = null;
            tmp = tmp.right;
        }
        tmp.right = null;
        tmp.left = null;
        return resultRoot;
    }

    //合并二叉树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 ==null&& t2 ==null) {
            return null;
        }
        if(t1 == null){
            return t2;
        }
        if(t2==null) {
            return t1;
        }
        t1.value = t1.value+t2.value;
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right, t2.right);
        return t1;
    }

    //二叉搜索树转换成累加树
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            dfs(root, 0);
        }
        return root;
    }
    private int dfs(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        sum = dfs(node.right, sum);
        node.value += sum;
        sum = dfs(node.left, node.value);
        return sum;
    }

}
