package 删除相同字符串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        StringBuffer s3 = new StringBuffer();
        int[] a = new int[s1.length()];
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for (int i = 0;i < arr2.length;i++) {
            char tmp = arr2[i];
            for (int j = 0;j < arr1.length;j++) {
                if(tmp == arr1[j]){
                    a[j] = 1;
                }
            }
        }
        for (int i = 0;i < arr1.length;i++) {
            if(a[i] == 0){
                s3.append(arr1[i]);
            }
        }
        System.out.println(s3);
    }
}

