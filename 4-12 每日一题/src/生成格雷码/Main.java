package 生成格雷码;

import java.util.Arrays;

public class Main {
    public static String[] getGrey(int n) {
        String[] str = null;
        if (n == 1) {
            str = new String[] {"0","1"};
        } else {
            String[] strs = getGrey(n-1);
            str = new String[2*strs.length];
            for(int i = 0;i < strs.length;i++){
                str[i] = "0"+strs[i];
                str[str.length-1-i] = "1"+strs[i];
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getGrey(1)));
        System.out.println(Arrays.toString(getGrey(3)));
    }
}
