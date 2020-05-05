package 密码验证合格;

import java.util.Scanner;

public class Main {
    public static boolean testLength(String password) {
        if (password == null || password.length() <= 8) {
            return false;
        }
        return true;
    }
    public static boolean testType(String password) {
        int flagA = 0;
        int flaga = 0;
        int flagNum = 0;
        int flagOther = 0;
        char[] arr = password.toCharArray();
        for (int i = 0;i < arr.length;i++) {
            if (arr[i] > 'A' && arr[i] < 'Z') {
                flagA = 1;
                continue;
            } else if (arr[i] > 'a' && arr[i] < 'z') {
                flaga = 1;
                continue;
            } else if (arr[i] > '0' && arr[i] < '9') {
                flagNum = 1;
            } else {
                flagOther = 1;
                continue;
            }
        }
        if (flagA+flaga+flagNum+flagOther < 3) {
            return false;
        }
        return true;
    }
    public static boolean testRepeat(String password) {
        for (int i = 0;i < password.length()-2;i++) {
            String s = password.substring(i,i+3);
            if (password.substring(i+1).contains(s)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String password = scanner.nextLine();
            if (testLength(password) && testType(password) && testRepeat(password)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }
}
