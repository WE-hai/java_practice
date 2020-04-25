package 最难的问题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] arr = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < s.length();i++) {
                if (arr[i] != ' ') {
                    if (arr[i] > 'E') {
                        arr[i] = (char)((int)arr[i]-5);
                    } else {
                        arr[i] = (char)(arr[i]-'E'+'Z');
                    }
                }
                sb.append(arr[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
