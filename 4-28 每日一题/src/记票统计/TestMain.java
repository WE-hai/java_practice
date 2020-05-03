package 记票统计;

import java.util.*;

public class TestMain {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Map<String, Integer> map = new LinkedHashMap<String, Integer>();
            for(int i=0; i<n; i++) {
                map.put(sc.next(),0);
            }
            int vote = sc.nextInt();
            int invalid = 0;
            for(int j=0; j<vote; j++) {
                String temp = sc.next();
                if(map.get(temp) == null) {
                    invalid ++;
                } else {
                    map.put(temp,map.get(temp)+1);
                }
            }
            for(Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            System.out.println("Invalid : "+invalid);
        }
    }
}