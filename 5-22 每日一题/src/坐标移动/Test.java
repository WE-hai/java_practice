package 坐标移动;

import java.util.*;

public class Test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            String[] A=str.split(";");
            int x=0,y=0;
            for(String string:A){
                if(string.charAt(0)=='D' && string.substring(1).matches("[0-9]+"))
                    x+=Integer.parseInt(string.substring(1));

                if(string.charAt(0)=='W' && string.substring(1).matches("[0-9]+"))
                    y+=Integer.parseInt(string.substring(1));

                if(string.charAt(0)=='S' && string.substring(1).matches("[0-9]+"))
                    y-=Integer.parseInt(string.substring(1));

                if(string.charAt(0)=='A' && string.substring(1).matches("[0-9]+"))
                    x-=Integer.parseInt(string.substring(1));
            }
            System.out.println(x+","+y);
        }
        sc.close();
    }
}
