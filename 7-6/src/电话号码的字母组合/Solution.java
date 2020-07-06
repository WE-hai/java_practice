package 电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    String[] mapString = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void backTrace(String dights, List<String> ret,StringBuilder curStr,int curDepth) {
        //边界，找到一种组合，放入数组中，结束此路径，向上回溯
        if (curDepth == dights.length()) {
            if (curStr.length() != 0) {
                ret.add(curStr.toString());
            }
            return;
        }
        //找到当前字符在String映射表中的位置
        int curMapIndex = dights.charAt(curDepth)-'0';
        String curMap = mapString[curMapIndex];
        //遍历每一种可能的组合
        for (int i = 0;i < curMap.length();i++) {
            backTrace(dights,ret,curStr.append(curMap.charAt(i)),curDepth+1);
            curStr.deleteCharAt(curStr.length()-1);
        }
    }

    public List<String> letterCombinations(String dights) {
        List<String> ret = new ArrayList<>();
        StringBuilder curStr = new StringBuilder("");
        backTrace(dights,ret,curStr,0);
        return ret;
    }
}
