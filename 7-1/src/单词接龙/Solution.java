package 单词接龙;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>();
        for (String wd : wordList) {
            wordDict.add(wd);
        }
        //标记单词是否已经访问过，访问过的不在访问
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int res = 1;
        while (!q.isEmpty()) {
            int nextSize = q.size();
            //每一步都要把队列中上一步添加的所有单词转换一遍
            //最短的转换肯定在这些单词当中，所有这些词的转换只能算一次转换
            //因为都是上一步转换出来的
            while (nextSize-- != 0) {
                String curWord = q.peek();
                q.poll();
                //尝试转换当前单词的每一个位置
                for (int i = 0;i < curWord.length();i++) {
                    StringBuilder newWord = new StringBuilder(curWord);
                    //每一个位置用26个字母分别转换
                    for (char ch = 'a';ch <= 'z';ch++) {
                        newWord.setCharAt(i,ch);
                        //如果列表中没有此单词或者已经访问过（它的转换已经遍历过，无需再次遍历），则跳过
                        String changeWord = newWord.toString();
                        if (!wordDict.contains(changeWord) || visited.contains(changeWord)) {
                            continue;
                        }
                        //转换成功，则在上一步转换的基础上+1
                        if (changeWord.equals(endWord)) {
                            return res+1;
                        }
                        //还没有转换成功，则新的单词入队
                        visited.add(changeWord);
                        q.offer(changeWord);
                    }
                }
            }
            res++;
        }
        //转换不成功
        return 0;
    }
}
