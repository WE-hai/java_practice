package Broken_Keyboard;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new java.util.Scanner(System.in);
        String originalString = input.nextLine();
        String typedOutString = input.nextLine();
        int[] keyboard = new int[128];
        // 扫描已键入的字符串，将小写字母转换成大写字母，使用 ASCII 码与 keyboard 对应，将成功键入的字符位置为 1
        for (int i = 0; i < typedOutString.length(); i++) {
            char ch = Character.toUpperCase(typedOutString.charAt(i));
            keyboard[ch] = 1;
        }
        // 扫描原始字符串，将小写字母转换成大小字母，去 keyboard 中检查是否已被成功键入，如果未成功键入，则打印对应的大写字母，
        // 并将 keyboard 中的对应的字符位置为 -1，表明已被打印
        for (int i = 0; i < originalString.length(); i++) {
            char ch = Character.toUpperCase(originalString.charAt(i));
            if (keyboard[ch] == 0) {
                System.out.print(ch);
                keyboard[ch] = -1;
            }
        }
    }
}
