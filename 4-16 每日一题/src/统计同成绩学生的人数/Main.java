package 统计同成绩学生的人数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0;i < arr.length;i++) {
                arr[i] = scanner.nextInt();
            }
            int grade = scanner.nextInt();
            int count = 0;
            for (int i = 0;i < arr.length;i++) {
                if (grade == arr[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
