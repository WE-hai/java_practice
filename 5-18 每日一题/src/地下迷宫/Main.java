package 地下迷宫;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int p = scanner.nextInt();
            int[][] map = new int[n][m];
            for (int i = 0;i < n;i++) {
                for (int j = 0;j < m;j++) {
                    map[i][j] = scanner.nextInt();
                }
            }
            boolean[][] flag = new boolean[n][m];
            List<Integer> list = new ArrayList<>();
            if (isTruePath(n,m,p,map,flag,list)) {
                for (int i = 0;i < list.size()-2;i += 2) {
                    System.out.print("["+list.get(i)+","+list.get(i+1)+"]"+",");
                }
                System.out.println("["+list.get(list.size()-2)+","+list.get(list.size()-1)+"]");
            } else {
                System.out.println("Can not escape!");
            }
        }
    }

    private static boolean isTruePath(int n, int m, int p, int[][] map, boolean[][] flag, List<Integer> list) {
        if (n < 0 || n >= map.length || m < 0 || m >= map.length
                || p < 0 || map[n][m] == 0 || flag[n][m] == true) {
            return false;
        }
        flag[n][m] = true;
        list.add(n);
        list.add(m);
        if (n == 0 && m == map[0].length-1) {
            return true;
        }
        if (isTruePath(n,m-1,p-1,map,flag,list)
                || isTruePath(n,m+1,p-1,map,flag,list)
                || isTruePath(n-1,m,p-3,map,flag,list)
                || isTruePath(n+1,m,p,map,flag,list)) {
            return true;
        }
        list.remove(list.size()-1);
        list.remove(list.size()-1);
        return false;
    }
}
