package DS.下厨房;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] arr = s.split(" ");
            for(int i = 0;i < arr.length;i++) {
                set.add(arr[i]);
            }
        }
        System.out.println(set.size());
    }
}