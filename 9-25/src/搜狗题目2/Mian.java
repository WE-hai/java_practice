package 搜狗题目2;

import java.util.Scanner;

public class Mian {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回一行字符串，表示原文。
     * @param s1 string字符串一维数组 N*N的01矩阵，表示解密纸，0表示透明，1表示涂黑
     * @param s2 string字符串一维数组 字符矩阵，表示密文
     * @return string字符串
     */
    public String rotatePassword (String[] s1, String[] s2) {
        // write code here
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0;i < s1.length;i++) {
            sb1.append(s1[i]);
            sb2.append(s2[i]);
        }
        String str1 = sb1.toString();
        String str2 = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        for (int i = 0;i < sb1.length();i++) {
            if (str1.charAt(i) == '0') {
                sb3.append(str2.charAt(i));
            }
        }
        StringBuilder sb4 = new StringBuilder();
        for (int i = s1[0].length()-1;i > 0;i--) {
            for (int j = 0;j < s1.length;j++) {
                sb4.append(s1[j].charAt(i));
            }
        }
        String str = sb4.toString();
        for (int i = 0;i < str.length();i++) {
            if (str.charAt(i) == '0') {
                sb3.append(str2.charAt(i));
            }
        }
        return sb3.toString();
    }
}
