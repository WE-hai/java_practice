package 字母统计;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] arr = s.toCharArray();
            int[] array = new int[256];
            for (char ch : arr) {
                array[ch]++;
            }
            for (int i = 'A';i <= 'Z';i++) {
                System.out.println((char)i+":"+array[i]);
            }
        }
    }
}
