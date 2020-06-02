package 骆驼命名法;

import java.util.*;

public class MainTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.next();
            char[] array = str.toCharArray();
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while(i < array.length){
                if(array[i] != '_'){
                    sb.append(array[i]);
                    i++;
                } else {
                    i++;
                    sb.append((array[i]+"").toUpperCase());
                    i++;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
