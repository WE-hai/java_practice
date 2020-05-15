package 锤子剪刀布;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static int match(char a,char b) {
        if (a == b) {
            return 0;
        } else if ((a == 'C' && b == 'J') || (a == 'B' && b == 'C') || (a == 'J' && b == 'B')) {
            return 1;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Map<Character,Integer> mapA = new TreeMap<>();
            Map<Character,Integer> mapB = new TreeMap<>();
            int sl = 0;
            int fail = 0;
            for (int i = 0;i < n;i++) {
                char a = scanner.next().charAt(0);
                char b = scanner.next().charAt(0);
                int win = match(a,b);
                if (win == 1) {
                    sl++;
                    if (mapA.containsKey(a)) {
                        mapA.put(a,mapA.get(a)+1);
                    } else {
                        mapA.put(a,1);
                    }
                } else if (win == -1) {
                    fail++;
                    if (mapB.containsKey(b)) {
                        mapB.put(b,mapB.get(b)+1);
                    } else {
                        mapB.put(b,1);
                    }
                }
            }
            System.out.println(sl+" "+(n-sl-fail)+" "+fail);
            System.out.println(fail+" "+(n-sl-fail)+" "+sl);
            int countWin = 0;
            for (Map.Entry<Character,Integer> map : mapA.entrySet()) {
                if (map.getValue() > countWin) {
                    countWin = map.getValue();
                }
            }
            if (countWin == 0) {
                System.out.print("B");
            } else {
                for (Map.Entry<Character,Integer> map : mapA.entrySet()) {
                    System.out.print(map.getKey());
                    break;
                }
            }
            System.out.print(" ");
            countWin = 0;
            for (Map.Entry<Character,Integer> map : mapB.entrySet()) {
                if (map.getValue() > countWin) {
                    countWin = map.getValue();
                }
            }
            if (countWin == 0) {
                System.out.print("B");
            } else {
                for (Map.Entry<Character,Integer> map : mapB.entrySet()) {
                    System.out.print(map.getKey());
                    break;
                }
            }
        }
    }
}
