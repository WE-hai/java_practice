package 骆驼命名法;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] arr = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < arr.length;i++) {
                if (arr[i] != '_') {
                    sb.append(arr[i]);
                } else {
                    i++;
                    sb.append((arr[i]+"").toUpperCase());
                }
            }
            System.out.println(sb.toString());
        }
    }
}
