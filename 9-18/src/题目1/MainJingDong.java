package 题目1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainJingDong {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        List<Integer>list=new ArrayList<>();
        while (scan.hasNextLine()){
            String str=scan.nextLine();
            int i=0;
            int j=0;
            while (i<str.length()){
                while (i<str.length()&&!isNumber(str.charAt(i))){
                    i++;
                }
                j=i;
                while (j<str.length()&&isNumber(str.charAt(j))){
                    j++;
                }
                if(j<=str.length()&&j-i==4){
                    if (isRightYear(str.substring(i,j))&&!list.contains(Integer.valueOf(str.substring(i,j)))){
                        list.add(Integer.valueOf(str.substring(i,j)));
                    }
                }
                i=j;
            }
            for(int k=0;k<list.size();k++){
                System.out.print(list.get(k));
                if (k!=list.size()-1){
                    System.out.print(" ");
                }
            }
        }

    }

    private static boolean isRightYear(String substring) {
        return  Integer.valueOf(substring)>=1000&&Integer.valueOf(substring)<=3999;
    }

    private static boolean isNumber(char c) {
        if(c>='0'&&c<='9'){
            return  true;
        }
        return  false;
    }
}
