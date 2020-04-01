import java.util.*;

public class Solution {
    //连续数组
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int cnt = 0;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                cnt++;
            } else {
                cnt--;
            }
            if(!map.containsKey(cnt)) {
                map.put(cnt, i);
            } else {
                if(i - map.get(cnt) > maxLen) {
                    maxLen = i - map.get(cnt);
                }
            }
        }
        return maxLen;
    }

    //存在重复元素2
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    //存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    //有效的数度
    public boolean isValidSudoku(char[][] board) {
        if(board == null)
            return false;
        if(board.length !=9)
            return false;
        int[] map = new int[9];
        for(int y=0; y<9; y++){
            if(board[y] == null || board[y].length != 9)
                return false;
            for(int x=0; x<9; x++){
                int key = board[y][x] - '1'; //key:数字
                if(key >= 0 && key <= 8) {  //1~9有效数字
                    int index = (1<<x)     //Value:位置编码，最低9位存放列号
                            | (1<<(y+9))    //中间9位存放行号
                            | (1<<(x/3 + y/3*3 + 18));  // z为9宫格区域序号
                    int old = map[key];
                    if((old & index) == 0) //无重复，则按位或，加入位置集合
                        map[key] = old | index;
                    else    //有重复
                        return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku2(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }

    //无重复的最长字串
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int a = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            a = Math.max(a, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return a;
    }

    //比较字符串最小字母的出现频次
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res=new int[queries.length];
        for (int j = 0; j < queries.length;j++){
            int countj=f(queries[j]);
            for (int i = 0; i < words.length;i++){
                int numi=f(words[i]);
                if(countj<numi)
                    res[j]++;
            }
        }
        return res;
    }
    public int f(String s) {
        int minsum=0;
        char[] c =s.toCharArray();
        char min=c[0];
        for (int i = 0; i < c.length;) {
            if(c[i]>=min)
                i++;
            else {
                min=c[i];
                i++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==min)
                minsum++;
        }
        return minsum;
    }

    //最常见的单词
    public String mostCommonWord(String paragraph, String[] banned) {
        //数组转Set
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        set.add("");
        paragraph += ".";
        //结果单词
        String res = " ";
        //最大单词出现次数
        int times = 0;
        //记录单词出现次数的map
        Map<String, Integer> map = new HashMap<>();
        //i,k为双指针
        int i = 0;
        for (int k = 0; k < paragraph.length(); k++) {
            char c = paragraph.charAt(k);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                continue;
            } else {
                //利用双指针截取出一个单词
                String word = paragraph.substring(i, k);
                //统一将单词转为小写
                word = word.toLowerCase();
                if (!set.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    //最大值的获取
                    if (map.get(word) > times) {
                        res = word;
                        times = map.get(word);
                    }
                }
                i = k + 1;
            }
        }
        return res;
    }

    //
}
