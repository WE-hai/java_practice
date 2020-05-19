package 木棒拼图;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] op = new int[n][2];
            for (int i = 0; i < n; i++) {
                op[i][0] = scanner.nextInt();
                op[i][1] = scanner.nextInt();
            }
            stickPuzzle(n, op);
        }
    }

    public static void stickPuzzle(int n, int[][] op) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (op[i][0] == 1) {
                list.add(op[i][1]);
            } else {
                list.remove(new Integer(op[i][1]));
            }
            if (canFormPoly(list)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
    //判断能否构成多边形
    //list：各边长
    public static boolean canFormPoly(ArrayList<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int temp = list.remove(i);
            int sum = 0;
            for (int j = 0; j < len - 1; j++) {
                sum += list.get(j);
            }
            if (sum <= temp) { //判断是否任意len-1条边之和大于剩余一条边
                list.add(i, temp);
                return false;
            }
            list.add(i, temp);
        }
        return true;
    }
}
