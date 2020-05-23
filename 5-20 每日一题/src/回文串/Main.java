package 回文串;

import java.util.Scanner;

public class Main {
    public static boolean isHuiWen(char[] arr,int i,int j) {
        while (i < j) {
            if (arr[i++] != arr[j--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] arr = s.toCharArray();
            boolean flag = true;
            int i = 0;
            int j = arr.length-1;
            while (i < j) {
                if (arr[i] != arr[j]) {
                    flag = isHuiWen(arr,i+1,j) || isHuiWen(arr,i,j-1);
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
