package 统计回文;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int count = 0;
            for (int i = 0; i <= a.length(); i++) {
                String str = a.substring(0, i) + b + a.substring(i, a.length());
                StringBuffer sb = new StringBuffer(str);
                if (sb.reverse().toString().equals(str)) {
                    count++;
                }
            }
            System.out.print(count);
        }
    }
}
