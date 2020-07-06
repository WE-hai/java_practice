package 打开转盘锁;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int openLock(String[] deadends,String target) {
        //哈希表的查找更快
        Set<String> deadendsSet = new HashSet<>();
        for (String str : deadends) {
            deadendsSet.add(str);
        }
        //如果“0000”在死亡字符串中，则永远到达不了
        if (deadendsSet.contains("0000")) {
            return -1;
        }
        Queue<String> que = new LinkedList<>();
        que.offer("0000");

        Set<String> book = new HashSet<>();
        book.add("0000");

        //加标记，已经搜索过的字符串不需要在次搜索
        int step = 0;
        while (!que.isEmpty()) {
            int n = que.size();
            //从上一步转换之后的字符串都需要进行验证和转换
            //并且只算做一次转换，类似于层序遍历，转换的步数和层相同
            //同一层的元素都是经过一步转换得到的
            for (int i = 0;i < n;i++) {
                String curStr = que.peek();
                que.poll();
                if (curStr.equals(target)) {
                    return step;
                }

                //4位密码锁，每个位置每次都可以转一次
                for (int j = 0;j < 4;j++) {
                    char newC1 = curStr.charAt(j);
                    char newC2 = curStr.charAt(j);
                    //当前位置可以向前或者向后拨一位
                    if (newC1 == '9') {
                        newC1 = '0';
                    } else {
                        ++newC1;
                    }
                    if (newC2 == '0') {
                        newC2 = '9';
                    } else {
                        --newC2;
                    }
                    StringBuilder newStr1 = new StringBuilder(curStr);
                    StringBuilder newStr2 = new StringBuilder(curStr);
                    newStr1.setCharAt(j,newC1);
                    newStr2.setCharAt(j,newC2);
                    if (!deadendsSet.contains(newStr1.toString()) && !book.contains(newStr2.toString())) {
                        que.offer(newStr1.toString());
                        book.add(newStr2.toString());
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
