package 二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    private Stack<Integer> path = new Stack();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        find(root, target, 0);
        return paths;
    }

    private void find(TreeNode root, int target, int cur) {
        if (cur == target && root == null) {
            paths.add(new ArrayList(path));
            return;
        }
        if (root == null) {
            return;
        }
        path.push(root.val);
        find(root.left, target, cur + root.val);
        path.pop();
        if (root.left == null && root.right == null) {
            return;
        }
        path.push(root.val);
        find(root.right, target, cur + root.val);
        path.pop();
    }
}