package 字母统计;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String[] ar = in.next().split("");
            HashMap<String,Integer> map = new HashMap<>();
            for(int i = 0; i <26 ; i++){
                char ch = (char) ('A'+i);
                String s = String.valueOf(ch);
                map.put(s,0);
            }
            for(int i = 0;i<ar.length;i++){
                if(ar[i].charAt(0)>='A'&&ar[i].charAt(0)<='Z'){
                    map.put(ar[i],map.get(ar[i])+1);
                }
            }
            for(String str:map.keySet())
                System.out.println(str+":"+map.get(str));
        }
    }
}