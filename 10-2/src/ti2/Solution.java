package ti2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root==null) return ret;
        solve(root, "", ret);
        return ret;
    }
    public void solve(TreeNode root, String cur, List<String> ret){
        if(root==null) return;
        cur += root.val;
        if(root.left==null&&root.right==null){
            ret.add(cur);
        }else{
            solve(root.left, cur+"->", ret);
            solve(root.right, cur+"->", ret);
        }
    }
}
