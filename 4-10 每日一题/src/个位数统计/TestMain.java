package 个位数统计;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class TestMain{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        char [] arr= sc.nextLine().toCharArray();
        Map <Character,Integer> number = new TreeMap<>();
        for (char c : arr) {
            if(number.containsKey(c)){
                number.put(c, number.get(c)+1);
            }else{
                number.put(c, 1);
            }
        }
        Iterator<Entry<Character, Integer>> it = number.entrySet().iterator();
        Entry<Character, Integer> en;
        while(it.hasNext()){
            en = it.next();
            System.out.println(en.getKey()+":"+en.getValue());
        }
    }
}