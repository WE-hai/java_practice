package DNA序列;

import java.util.Scanner;

public class MainTest {

    public static String maxGC(String str, int len){
        if (str.length() == len) {
            return str;     //一开始只过90%是因为长度相同的用例，记得处理一下
        }
        int GCCount = 0;      //记录子串中的GC数量；
        String res = "";
        for (int i = 0; i < str.length()-len; i++){
            String temp = str.substring(i,i+len);
            int cnt = 0;
            for (char c : temp.toCharArray()){
                if (c == 'G' || c == 'C'){
                    cnt++;
                }
            }
            if (cnt > GCCount){
                GCCount = cnt;
                res = temp;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int n = scanner.nextInt();
            String ret = maxGC(s,n);
            System.out.println(ret);
        }
    }
}
