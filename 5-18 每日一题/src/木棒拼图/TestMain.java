package 木棒拼图;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        int i=0;
        while (n>0){
            int op=sc.nextInt();
            int l=sc.nextInt();
            if(op==1){
                list.add(l);
                canForm(list);
            }
            if(!list.isEmpty()&&op==2&&list.contains(l)){
                int index=list.indexOf(l);
                list.remove(index);
                canForm(list);
            }
            n--;
        }
    }

    private static void canForm(List<Integer> list) {
        if(list.isEmpty()||list.size()<3){
            System.out.println("No");
            return;
        }
        int sum=0;
        int max=list.get(0);
        for(int i=0;i<list.size();i++){
            int temp=list.get(i);
            sum+=temp;
            if(temp>max){
                max=temp;
            }
        }
        if(max<sum-max){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}