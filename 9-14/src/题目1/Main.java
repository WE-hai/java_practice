package 题目1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0;i < s.length();i++) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    if (!map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i),1);
                    } else {
                        map.put(s.charAt(i),map.get(s.charAt(i))+1);
                    }
                }
            }
            for (Map.Entry<Character,Integer> m : map.entrySet()) {
                System.out.print(m.getKey()+"="+m.getValue()+" ");
            }
        }
    }
}
