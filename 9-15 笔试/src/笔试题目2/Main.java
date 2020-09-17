package 笔试题目2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[][] board = new String[200][200];
            String boardString = scanner.next();
            String[] strings = boardString.split(",");
            int len = 0;
            while (len <= strings.length) {
                for (int i = 0;i < strings.length;i++) {
                    for (int j = 0;j < strings.length;j++) {
                        board[i][j] = strings[len];
                        len++;
                    }
                }
            }
            System.out.println(Arrays.toString(board));
        }
    }
}
