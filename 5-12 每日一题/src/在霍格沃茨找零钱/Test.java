package 在霍格沃茨找零钱;

import java.util.*;

public class Test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String p=sc.next();
        String a=sc.next();
        String[] pMoney=p.split("\\.");
        String[] aMoney=a.split("\\.");
        int pTotal=Integer.valueOf(pMoney[0])*17*29+Integer.valueOf(pMoney[1])*29+Integer.valueOf(pMoney[2]);
        int aTotal=Integer.valueOf(aMoney[0])*17*29+Integer.valueOf(aMoney[1])*29+Integer.valueOf(aMoney[2]);
        int sight=1;
        int different=aTotal-pTotal;
        if(different<0){
            different=-different;
            sight=-sight;
        }
        int p1=different/(17*29);
        int p2=(different-p1*17*29)/29;
        int p3=(different-p1*17*29-p2*29);
        p1*=sight;
        System.out.println(p1+"."+p2+"."+p3);
    }
}