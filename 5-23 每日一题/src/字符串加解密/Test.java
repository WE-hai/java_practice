package 字符串加解密;

import java.util.*;

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            for(int i=0; i<ch1.length; i++) {
                if(ch1[i]>='A' && ch1[i]<'Z') {
                    ch1[i] = (char)(ch1[i]+33);
                }else if(ch1[i] == 'Z') {
                    ch1[i] = 'a';
                }else if(ch1[i]>='a' && ch1[i]<'z') {
                    ch1[i] = (char)(ch1[i]-31);
                }else if(ch1[i] == 'z') {
                    ch1[i] = 'A';
                }else if(ch1[i]>='0' && ch1[i]<'9') {
                    ch1[i] = (char)(ch1[i]+1);
                }else if(ch1[i] == '9') {
                    ch1[i] = '0';
                }
            }
            for(int i=0; i<ch2.length; i++) {
                if(ch2[i]>'A' && ch2[i]<='Z') {
                    ch2[i] = (char)(ch2[i]+31);
                }else if(ch2[i] == 'A') {
                    ch2[i] = 'z';
                }else if(ch2[i]>'a' && ch2[i]<='z') {
                    ch2[i] = (char)(ch2[i]-33);
                }else if(ch2[i] == 'a') {
                    ch2[i] = 'Z';
                }else if(ch2[i]>'0' && ch2[i]<='9') {
                    ch2[i] = (char)(ch2[i]-1);
                }else if(ch2[i] == '0') {
                    ch2[i] = '9';
                }
            }
            String jiami = String.copyValueOf(ch1);
            String jiemi = String.copyValueOf(ch2);
            System.out.println(jiami);
            System.out.println(jiemi);
        }
    }
}