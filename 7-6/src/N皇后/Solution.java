package N皇后;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        //按坐标位置存放所有解决方案
        List<List<Pair>> solutions = new ArrayList<>();
        //存放一种解决方案中所有皇后的位置
        List<Pair> solution = new ArrayList<>();

        nQueensBacktrack(solutions,solution,0,n);

        //把坐标位置转成string
        return transResult(solutions,n);
    }

    private List<List<String>> transResult(List<List<Pair>> solutions, int n) {
        List<String> tmp = new ArrayList<>();
        //把每一种解决方案转换为String形式，最终结果
        List<List<String>> ret = new ArrayList<>();
        for (List<Pair> solution : solutions) {
            //n*n char：每行有n个元素，把最后皇后的位置修改为Q
            List<StringBuilder> solutionString = new ArrayList<>();
            for (int i = 0;i < n;i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0;j < n;j++) {
                    sb.append('.');
                }
                solutionString.add(sb);
            }
            for (Pair i : solution) {
                solutionString.get(i.x).setCharAt(i.y,'Q');
            }
            List<String> curRet = new ArrayList<>();
            for (StringBuilder sb : solutionString) {
                curRet.add(sb.toString());
            }
            ret.add(curRet);
        }
        return ret;
    }

    private void nQueensBacktrack(List<List<Pair>> solutions, List<Pair> solution, int curRow, int n) {
        if (curRow == n) {
            List<Pair> news = new ArrayList<>();
            for (Pair p : solution) {
                news.add(p);
            }
            solutions.add(news);
        }
        //尝试当前行的每一个位置是否可以放置一个皇后
        for (int col = 0;col < n;col++) {
            if (isValid(solution,curRow,col)) {
                //如果可以，在保存当前位置，继续确定下一行皇后的位置
                //直接调用构造函数，内部的构造Pair，或者调用Make_pair
                solution.add(new Pair(curRow,col));
                nQueensBacktrack(solutions,solution,curRow+1,n);
                solution.remove(solution.size()-1);
            }
        }
    }

    boolean isValid(List<Pair> solution,int row,int col) {
        //判断当前行尝试的皇后位置是否和前面几行的皇后位置有冲突
        //i.second == col:第i个皇后与当前这个在同一列
        //i.first+i.second == row+col：第i个皇后与当前点在撇上，横坐标+纵坐标值相同
        //i.first-i.second == row-col：第i个皇后与当前点在捺上，横坐标-纵坐标值相同
        for (Pair i : solution) {
            if (i.y == col || i.x+i.y == row+col || i.x-i.y == row-col) {
                return false;
            }
        }
        return true;
    }
}
