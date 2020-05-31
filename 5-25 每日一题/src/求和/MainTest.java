package 求和;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {
    public static void printList(int m,int n,List<Integer> list){
        if(m == 0){
            System.out.println(list);
            return;
        }
        if(n<=0 || m<0){
            return;
        }
        List list1 = new ArrayList<>(list);
        printList(m, n-1, list);
        list1.add(n);
        printList(m-n, n-1, list1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m  = in.nextInt();
        List<Integer> list = new ArrayList<>();
        int up = n > m ? m : n;
        printList(m,up,list);
    }
}