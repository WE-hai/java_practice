package 题目1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            Map<Character,Integer> map1 = new HashMap<>();
            Map<Character,Integer> map2 = new HashMap<>();
            for (int i = 0;i < s1.length();i++) {
                if (!map1.containsKey(s1.charAt(i))) {
                    map1.put(s1.charAt(i),1);
                } else {
                    map1.put(s1.charAt(i),map1.get(s1.charAt(i))+1);
                }
            }
//            for (int i = 0;i < s2.length();i++) {
//                if (!map2.containsKey(s2.charAt(i))) {
//                    map2.put(s2.charAt(i),1);
//                } else {
//                    map2.put(s2.charAt(i),map2.get(s2.charAt(i))+1);
//                }
//            }
            int count = 0;
            for (Map.Entry<Character,Integer> m : map1.entrySet()) {

            }
        }
    }
}
