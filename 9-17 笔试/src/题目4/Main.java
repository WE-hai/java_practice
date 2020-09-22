package 题目4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < s.length();i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    sb.append(s.charAt(i));
                }
                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    sb.append(" ");
                }
            }
            String str = sb.toString();
            String[] strings = str.split(" ");
            List<String> list = new ArrayList<>();
            for (int i = 0;i < strings.length;i++) {
                if (strings[i].length() == 4) {
                    list.add(strings[i]);
                }
            }

            for (int i = 0;i < list.size();i++) {
                if (Integer.parseInt(list.get(i)) >= 1000 && Integer.parseInt(list.get(i)) < 4000) {
                    System.out.print(list.get(i)+" ");
                }
            }
        }
    }
}
