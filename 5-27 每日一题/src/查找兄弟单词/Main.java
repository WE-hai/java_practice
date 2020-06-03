package 查找兄弟单词;

import java.util.*;

public class Main {
    public static int check(String key,String word,char[] keyChar) {
        if (key.equals(word) || key.length() != word.length()) {
            return 0;
        }
        char[] wordChar = word.toCharArray();
        Arrays.sort(wordChar);
        return Arrays.equals(keyChar,wordChar) ? 1 : 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] dic = new String[n];
            for (int i = 0;i < n;i++) {
                dic[i] = scanner.next();
            }
            String key = scanner.next();
            int num = scanner.nextInt();
            char[] arr = key.toCharArray();
            Arrays.sort(arr);
            List<String> list = new ArrayList<>();
            int count = 0;
            for (int i = 0;i < n;i++) {
                int c = check(key,dic[i],arr);
                count += c;
                if (c == 1) {
                    list.add(dic[i]);
                }
            }
            System.out.println(count);
            Collections.sort(list);
            if (count >= num) {
                System.out.println(list.get(num-1));
            }
        }
    }
}
