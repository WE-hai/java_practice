package 骆驼命名法;

import java.util.*;

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            change(str);
        }
    }

    private static void change(String str) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            boolean flg=false;
            while(str.charAt(i)=='_'){
                i++;
                flg=true;
            }
            if(flg){
                ret.append((char)(str.charAt(i)-32));
                continue;
            }
            ret.append(str.charAt(i));
        }
        System.out.println(ret.toString());
    }
}