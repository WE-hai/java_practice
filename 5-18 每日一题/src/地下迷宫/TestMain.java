package 地下迷宫;

import java.util.*;

public class TestMain{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            int m=input.nextInt();
            int P=input.nextInt();
            int[][] a=new int[n][m];
            for(int i=0; i<n; i++)
                for(int j=0; j<m; j++)
                    a[i][j]=input.nextInt();
            boolean[][] flag=new boolean[n][m];
            ArrayList<Integer> path=new ArrayList<>();

            if(isTruePath(0,0,P,a,path,flag)){
                for(int i=0; i<path.size()-2; i+=2)
                    System.out.print("["+path.get(i)+","+path.get(i+1)+"]"+",");
                System.out.println("["+path.get(path.size()-2)+","+path.get(path.size()-1)+"]");
            }else{
                System.out.println("Can not escape!");
            }
        }
    }
    public static boolean isTruePath(int i, int j, int P, int[][] a, ArrayList<Integer> path, boolean[][] flag){
        if(i<0 || i>=a.length || j<0 || j>=a[0].length || P<0 || a[i][j]==0|| flag[i][j]==true)
            return false;
        flag[i][j]=true;
        path.add(i);
        path.add(j);
        if(i==0 && j==a[0].length-1){
            return true;
        }
        if(isTruePath(i,j-1,P-1,a,path,flag)||
                isTruePath(i,j+1,P-1,a,path,flag)||
                isTruePath(i-1,j,P-3,a,path,flag)||
                isTruePath(i+1,j,P,a,path,flag))
            return true;
        path.remove(path.size()-1);
        path.remove(path.size()-1);
        return false;
    }
}