package 单词倒排;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] arr = s.split("[^a-zA-Z]+");
            for (int i = arr.length-1;i >= 0;i--) {
                System.out.print(arr[i]+" ");
            }
        }
    }
}
