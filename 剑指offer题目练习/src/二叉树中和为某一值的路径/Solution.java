package 二叉树中和为某一值的路径;

import java.util.ArrayList;

public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) {
            return result;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(list));
        }
        //因为在每一次的递归中，我们使用的是相同的result引用，所以其实左右子树递归得到的结果我们不需要关心，
        //可以简写为FindPath(root.left, target)；FindPath(root.right, target)；
        //但是为了大家能够看清楚递归的真相，此处我还是把递归的形式给大家展现了出来。
        ArrayList<ArrayList<Integer>> result1 = FindPath(root.left, target);
        ArrayList<ArrayList<Integer>> result2 = FindPath(root.right, target);
        list.remove(list.size()-1);
        return result;
    }
}
