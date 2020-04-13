package 个位数统计;

import java.util.*;

public class Main {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] num = new int[10];
        for(char c : s.toCharArray()){
            num[c-'0']++;
        }
        for(int i = 0;i < 10;i++){
            if(num[i] != 0) {
                System.out.println(i + ":" + num[i]);
            }
        }
    }
}