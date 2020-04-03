package 删除相同字符串;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        for (int i = 0;i < arr2.length;i++) {
            char ch = arr2[i];
            for (int j = 0;j < arr1.length;j++) {
                if (ch != arr1[i]) {

                    //break;
                }
            }
        }
        StringBuffer s = new StringBuffer();
        System.out.println(s);
    }
}
