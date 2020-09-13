package 题目1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int len = scanner.nextInt();
            String s = scanner.next();
            char[] chars = s.toCharArray();
            List<String> list = new ArrayList<>();
            for (int i = 0;i < chars.length;i++) {
                StringBuilder sb = new StringBuilder(len);
                for (int j = 0;j < len;j++) {
                    if (sb.length() < len) {
                        sb.append(chars[i]);
                    }
                    list.add(sb.reverse().toString());
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0;i < list.size();i++) {
                stringBuilder.append(list.get(i));
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
