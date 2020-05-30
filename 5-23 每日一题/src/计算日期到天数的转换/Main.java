package 计算日期到天数的转换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int date = scanner.nextInt();
            int days = 0;
            int[] arr = {31,28,31,30,31,30,31,31,30,31,30,31};
            if (month > 12 || date > 31 || year < 0 || month <= 0 || date <= 0 || date > arr[month-1]) {
                System.out.println(-1);
            }
            if (year%4 == 0 && year%100 != 0 || year%400 == 0) {
                arr[1] = 29;
            }
            for (int i = 0;i < month-1;i++) {
                days += arr[i];
            }
            System.out.println(days+date);
        }
    }
}
