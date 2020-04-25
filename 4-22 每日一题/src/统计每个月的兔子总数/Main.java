package 统计每个月的兔子总数;

import java.util.Scanner;

public class Main {
    public static int getCount(int month) {
        if (month == 1 || month == 2) {
            return 1;
        }
        if (month == 3) {
            return 2;
        }
        return getCount(month-1) + getCount(month-2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int month = scanner.nextInt();
            System.out.println(getCount(month));
        }
    }
}
