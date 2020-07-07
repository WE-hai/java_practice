package 组合总和;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void dfs(int[] candidates, List<List<Integer>> solutions,List<Integer> solution,int curSum,int prevPosition,int target) {
        //边界，如果大于等于目标，则结束
        if (curSum >= target) {
            //等于目标，找到一个组合
            if (curSum == target) {
                List<Integer> news = new ArrayList<>();
                for (int e : solution) {
                    news.add(e);
                }
                solutions.add(news);
            }
            return;
        }
        //可以从上一个位置开始，因为元素可以重复
        for (int i = prevPosition;i < candidates.length;i++) {
            //单个值已经大于目标，直接跳过
            if (candidates[i] > target) {
                continue;
            }
            solution.add(candidates[i]);
            dfs(candidates, solutions, solution, curSum+candidates[i], i, target);
            //回溯，向上回退
            solution.remove(solution.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates,int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        if (candidates.length == 0) {
            return solutions;
        }
        int curSum = 0;
        dfs(candidates,solutions,solution,curSum,0,target);
        return solutions;
    }



}
