package 全排列2;

import java.util.*;

public class Main {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, nums.length, new ArrayDeque<>(), new HashSet<>());
        return res;
    }

    private void dfs(int[] nums, int n, Deque<Integer> path, Set<Integer> set) {
        if(path.size() == n) {
            res.add(new ArrayList<>(path));
        }
        for(int i=1; i<=n; i++) {
            if(i>1 && nums[i-1] == nums[i-2] && !set.contains(i-1)) continue;
            if(set.contains(i)) continue;

            set.add(i);
            path.addLast(nums[i-1]);
            dfs(nums, n, path, set);
            path.removeLast();
            set.remove(i);
        }
    }
}
