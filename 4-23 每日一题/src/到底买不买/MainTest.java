package 到底买不买;

import java.util.Scanner;

public class MainTest{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();
        char[] ch1 =str1.toCharArray();//卖家
        char[] ch2 = str2.toCharArray();//买家
        boolean tag = true;     //tag为true表示买家想要的都有
        for(int j = 0; j < ch2.length; ++j){
            int flag = 1;   // 买家想要的第j个卖家是否有
            for(int i = 0; i < ch1.length; ++i){
                if(ch1[i] == ch2[j]){        //如果卖家有，将其置为空，防止下次再次匹配到
                    ch1[i] = ' ';           //最后扫描一下，不是空格的个数，就是多余的个数
                    flag = 0;
                    break;
                }
            }
            if(flag != 0){      //说明卖家没有买家想要的
                ch2[j] = ' ';   //买家置为空，最后扫描一下空格的个数，就是没有匹配成功的个数
                tag = false;    //买家有一个没有买到，说明就为No
            }
        }
        if(tag){
            int count = 0;
            for(int i = 0; i < ch1.length; ++i) {
                if (ch1[i] != ' ') {
                    count++;
                }
            }
            System.out.print("Yes"+" "+count);
        } else {
            int count =0;
            for(int i = 0; i < ch2.length; ++i) {
                if (ch2[i] == ' ') {
                    count++;
                }
            }
            System.out.println("No"+" "+count);
        }
    }
}