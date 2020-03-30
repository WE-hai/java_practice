package 回文字符串;

import java.util.*;

public class Main {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while(scanner.hasNextLine()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            for(int i = 0;i <= a.length();i++) {
                StringBuilder s = new StringBuilder(a);
                s.insert(i,b);
                if(isPalindrome(s.toString())) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}