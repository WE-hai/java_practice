package 字符串分割;

import java.util.Set;

public class Main {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length()+1];
        //初始化F(0) = true
        canBreak[0] = true;
        for (int i = 1;i <= s.length();i++) {
            for (int j = i-1;j >= 0;j--) {
                // F(i): true{j <i && F(j) && substr[j+1,i]能在词典中找到} OR false
                 // 第j+1个字符的索引为j
                if (canBreak[j] && dict.contains(s.substring(j,i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}
