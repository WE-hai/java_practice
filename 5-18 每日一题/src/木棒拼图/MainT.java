package 木棒拼图;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainT {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            long[][] data=new long[n][2];
            for(int i=0;i<n;i++){
                data[i][0]=sc.nextLong();
                data[i][1]=sc.nextLong();
            }
            dealWith(data);
        }
    }

    public static void dealWith(long[][] data){
        List<Long> sticks=new ArrayList<Long>();
        for(int i=0;i<data.length;i++){
            if(data[i][0]==1)
                sticks.add(data[i][1]);
            else
                sticks.remove(data[i][1]);
            judge(sticks);
        }
    }

    public static void judge(List<Long> sticks){
        if(sticks.size()<3)
            System.out.println("No");
        else{
            Collections.sort(sticks);
            long sum=0;
            int i=0;
            for(i=0;i<sticks.size()-1;i++){
                sum+=sticks.get(i);
            }
            if(sum>sticks.get(i))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}