package 记票统计;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int candidateNum = sc.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < candidateNum; i++) {
                String name = sc.next();
                list.add(name);
            }
            int voteNum = sc.nextInt();
            int[] arr = new int[candidateNum];
            int invalidNum = 0;
            for (int i = 0; i < voteNum; i++) {
                String name = sc.next();
                if (list.contains(name)){
                    int index = list.indexOf(name);
                    arr[index]++;
                }else {
                    invalidNum++;
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i)+" : "+arr[i]);
            }
            System.out.println("Invalid : "+invalidNum);
        }
    }
}