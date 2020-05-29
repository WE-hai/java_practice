package 坐标移动;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] arr = s.split(";");
            int x = 0;
            int y = 0;
            for (int i = 0;i < arr.length;i++) {
                int b = Integer.valueOf(arr[i].substring(1,arr[i].length()));
                switch (arr[i].charAt(0)) {
                    case 'A' :
                        x -= b;
                        break;
                    case 'W':
                        y += b;
                        break;
                    case 'D':
                        x += b;
                        break;
                    case 'S':
                        y -= b;
                        break;
                        default:
                            System.out.println("无效");
                            continue;
                }
            }
            System.out.println(x+","+y);
        }
    }
}
