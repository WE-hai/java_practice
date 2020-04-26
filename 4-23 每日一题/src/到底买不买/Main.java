package 到底买不买;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String str = scanner.nextLine();
            int count = 0;
            List<Character> list = new ArrayList<>();
            for (int i = 0;i < s.length();i++) {
                char ch = s.charAt(i);
                list.add(ch);
            }
            for (int i = 0;i < str.length();i++) {
                char ch = str.charAt(i);
                for (int j = 0;j < list.size();j++) {
                    if (list.get(j) == ch) {
                        list.remove(j);
                        count++;
                        break;
                    }
                }
            }
            if (count == str.length()) {
                System.out.println("Yes"+" "+(s.length()-count));
            } else {
                System.out.println("No"+" "+(str.length()-count));
            }
        }
    }
}
