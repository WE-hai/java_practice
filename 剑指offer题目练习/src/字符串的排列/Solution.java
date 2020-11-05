package 字符串的排列;

import java.util.ArrayList;

/**
 思路：a b c
 使用的递归思路
 1，先确定第一个数a，剩余bc
 2，再确定第二个数b，剩余c
 3，判断就剩一个数了，把路径存起来

 思路还挺好想，主要是怎么写代码。看下面吧，不太好讲。
 */
public class Solution {
    public ArrayList<String> list = new ArrayList();

    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0){
            return list;
        }
        // str 转 list
        String[] strArray = str.split("");
        ArrayList<String> strlist = new ArrayList();
        for (String s : strArray) {
            strlist.add(s);
        }
        StringBuilder sb = new StringBuilder();
        this.add(strlist, sb);

        return list;
    }

    public void add(ArrayList<String> str, StringBuilder sb){
        // 当等于str大小是1时，说明遍历到最后一个元素，存到list
        if(str.size() == 1){
            sb.append(str.get(0));
            // 判断list中是否有重复，去重
            int i = list.indexOf(sb.toString());
            if(i == -1){
                list.add(sb.toString());
            }
            return;
        }

        // 遍历所有可能情况 abc
        for (int i = 0; i<str.size(); i++) {
            StringBuilder newSb = new StringBuilder();
            // 把之前路径存下
            newSb.append(sb.toString());
            // 存当前元素a/b/c
            newSb.append(str.get(i));

            // 确定a/b/c后，删除，下次递归使用剩余元素
            ArrayList<String> temp = new ArrayList(str);
            temp.remove(i);
            this.add(temp, newSb);
        }

    }
}
