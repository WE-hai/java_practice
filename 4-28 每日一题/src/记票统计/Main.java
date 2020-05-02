package 记票统计;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Map<String,Integer> map = new LinkedHashMap<>();
            //注意用LinkedHashMap，其他的Map不能通过
            int n = scanner.nextInt();
            for (int i = 0;i < n;i++) {
                map.put(scanner.next(),0);
            }
            int vote = scanner.nextInt();
            int invalid = 0;
            for (int i = 0;i < vote;i++) {
                String name = scanner.next();
                if (map.get(name) == null) {
                    invalid++;
                } else {
                    map.put(name,map.get(name)+1);
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            System.out.println("Invalid : "+invalid);
        }
    }
}
