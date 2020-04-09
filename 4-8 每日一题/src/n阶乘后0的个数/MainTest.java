package n阶乘后0的个数;

import java.util.Scanner;

public class MainTest {
    public static long fac(int n) {
        if (n == 1) {
            return 1;
        }
        return n*fac(n-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n > 1000 || n < 0) {
                break;
            }
            long cheng = fac(n);
            String s = Long.toString(cheng);
            for (int i = s.length()-1;i >= 0;i--) {
                if (s.charAt(i) == '0') {
                    count++;
                } else {
                    break;
                }
            }
            /*
            char[] chs = s.toCharArray();
            for (int i = chs.length-1;i > 0;i--) {
                if (chs[i] == '0') {
                    count++;
                } else {
                    break;
                }
            }
            */
            System.out.println(count);
        }
    }
}
