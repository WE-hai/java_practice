package 活字印刷;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public void dfs(String tiles, StringBuilder curStr, List<Integer> usedIdx, Set<String> totalString) {
        if (curStr.length() != 0) {
            totalString.add(curStr.toString());
        }
        //标记保证所有位都用完之后，就结束了
        for (int i = 0;i < tiles.length();i++) {
            //当前位置的字符已用过，直接跳过
            if (usedIdx.get(i) == 1) {
                continue;
            }
            usedIdx.set(i,1);
            dfs(tiles, curStr.append(tiles.charAt(i)), usedIdx, totalString);
            //回溯，尝试其他字符
            usedIdx.set(i,0);
            curStr.deleteCharAt(curStr.length()-1);
        }
    }

    public int numTilePossibilities(String tiles) {
        if (tiles.length() == 0) {
            return 0;
        }
        Set<String> totalString = new HashSet<>();
        //标记全部初始化为未使用
        List<Integer> usedIdx = new ArrayList<>();
        for (int i = 0;i < tiles.length();i++) {
            usedIdx.add(0);
        }
        StringBuilder curStr = new StringBuilder("");
        dfs(tiles,curStr,usedIdx,totalString);
        return totalString.size();
    }
}
