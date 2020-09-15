package 网易;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()){
            String str = scan.nextLine();
            System.out.println(many(str));
        }
    }

    private static int many(String str) {
        int cnt = 0;
        int len = str.length();
        for(int i = 0;i < str.length();i++){
            for(int l = i,r = i;l >= 0 && r < len
                    && str.charAt(l) == str.charAt(r);l--,r++) {
                if (r-l>0){
                    cnt++;
                }
            }

            for(int l = i,r = i+1;l >= 0 && r < len
                    && str.charAt(l) == str.charAt(r);l--,r++) {
                cnt++;
            }
        }
        return  cnt;
    }
}
