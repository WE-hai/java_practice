package 字符串中最长数字串;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            String[] arr = str.split("\\D");
            String sss = arr[0];
            int max = arr[0].length();
            for(int i = 1;i < arr.length;i++) {
                if(arr[i].length() > max) {
                    sss = arr[i];
                    max = arr[i].length();
                } else if(arr[i].length() == max) {
                    sss += arr[i];
                }
            }
            System.out.println(sss+","+max);
        }
    }
}
