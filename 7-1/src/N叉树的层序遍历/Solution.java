package N叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> treeVec = new ArrayList<>();
        if (root == null) {
            return treeVec;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            //获取当前层元素个数，即整个队列元素
            int size = q.size();
            //临时存放每一层的元素
            List<Integer> newFloor = new ArrayList<>();
            while (size-- != 0) {
                Node node = q.peek();
                q.poll();
                newFloor.add(node.val);
                //孩子入队
                for (Node child : node.children) {
                    if (child != null) {
                        q.offer(child);
                    }
                }
            }
            //新层有元素，则放入treeVec
            if (!newFloor.isEmpty()) {
                treeVec.add(newFloor);
            }
        }
        return treeVec;
    }
}
