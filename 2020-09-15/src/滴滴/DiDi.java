package 滴滴;

import java.util.Scanner;

public class DiDi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()){
            int n = Integer.valueOf(scan.nextLine());
            String str = scan.nextLine();
            System.out.println(change(str,n));
        }
    }

    private static String change(String str, int n) {
        if (str.length() <= n){
            return new StringBuilder(str).reverse().toString();
        }
        int cnt = str.length()/n;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < cnt;i++) {
            int idx = n*i;
            String cur = new StringBuilder(str.substring(idx,idx+n)).reverse().toString();
            sb.append(cur);
        }
        sb.append(new StringBuilder(str.substring(cnt*n)).reverse().toString());
        return sb.toString();
    }
}
