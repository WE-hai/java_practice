package 电话号码;

import java.util.*;

public class Main {
    public static String change(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0;i < arr.length;i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                sb.append(arr[i]);
            }
            if (arr[i] >= 'A' && arr[i] <= 'C') {
                sb.append('2');
            }
            if (arr[i] >= 'D' && arr[i] <= 'F') {
                sb.append('3');
            }
            if (arr[i] >= 'G' && arr[i] <= 'I') {
                sb.append('4');
            }
            if (arr[i] >= 'J' && arr[i] <= 'L') {
                sb.append('5');
            }
            if (arr[i] >= 'M' && arr[i] <= 'O') {
                sb.append('6');
            }
            if (arr[i] >= 'P' && arr[i] <= 'S') {
                sb.append('7');
            }
            if (arr[i] >= 'T' && arr[i] <= 'V') {
                sb.append('8');
            }
            if (arr[i] >= 'W' && arr[i] <= 'Z') {
                sb.append('9');
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<String> list = new ArrayList<>();
            String[] arr = new String[n];
            for (int i = 0;i < n;i++) {
                arr[i] = scanner.next();
                String ret = change(arr[i]);
                ret = ret.substring(0,3)+"-"+ret.substring(3,7);
                if (!list.contains(ret)) {
                    list.add(ret);
                }
            }
            Collections.sort(list);
            for (int i = 0;i < list.size();i++) {
                System.out.println(list.get(i));
            }
            System.out.println();
        }
    }
}
