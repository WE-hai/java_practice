package 回文串;

import java.util.Scanner;

public class Huiwen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.nextLine();
            char[] c = s.toCharArray();
            int i = 0, j = c.length - 1;
            boolean result = true;
            while (i < j) {
                // i从左向右扫描，j从右向左扫描，找到第一对不相同的字符c[i]和c[j]
                if (c[i] != c[j]) {
                    // 此时c[i]~c[j]不是回文串
                    // 只有当c[i+1]~c[j]为回文串或c[i]~c[j-1]为回文串时
                    // 才能通过添加一个字符使c[i]~c[j]成为回文串
                    // （若c[i+1]~c[j]为回文串，就在c[j]的右边添加和c[i]相同的，
                    // 若c[i]~c[j-1]为回文串，就在c[i]的左边添加和c[j]相同的）
                    result = isHuiWen(c, i + 1, j) || isHuiWen(c, i, j - 1);
                    break;
                }
                i++;
                j--;
            }
            System.out.println(result? "YES" : "NO");
        }
    }

    private static boolean isHuiWen(char[] c, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            if (c[i++] != c[j--]) {
                return false;
            }
        }
        return true;
    }
}