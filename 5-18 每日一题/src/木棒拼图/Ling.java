package 木棒拼图;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ling {
    private static void lengthOfSide(int[][] temp,int n){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(temp[i][0]==1){
                list.add(temp[i][1]);
            }else{
                list.remove(new Integer(temp[i][1]));
            }
            if(judge(list)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }

    private static boolean judge(List<Integer> list){
        if(list.size()<3) {
            return false;
        } else {
            Collections.sort(list);
            int sum=0;
            int size=list.size()-1;
            for(int i=0;i<size;i++){
                sum+=list.get(i);
            }
            if(sum<=list.get(size)){
                return false;
            }else{
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[][] temp=new int[n][2];
            for(int i=0;i<n;i++){
                temp[i][0]=sc.nextInt();
                temp[i][1]=sc.nextInt();
            }
            lengthOfSide(temp,n);
        }
    }
}