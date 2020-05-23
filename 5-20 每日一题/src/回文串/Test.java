package 回文串;

import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();

            char[] chas = str.toCharArray();
            boolean flag = false;

            for (int i=0; i<chas.length; ++i){
                //复制
                String str1 = String.copyValueOf(chas);
                char[] chas1 = str1.toCharArray();
                chas1[i] = ' '; //每次删除一个
                String s = String.valueOf(chas1).replaceAll(" ", "");
                if (isPa(s)){
                    flag = true;
                }
            }

            if (flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    //判断是否是回文字符串
    public static boolean isPa(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
