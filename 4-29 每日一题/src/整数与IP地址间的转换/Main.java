package 整数与IP地址间的转换;

import java.util.Scanner;

public class Main {
    public static void tenToIp(String ip10) {
        long p = Long.parseLong(ip10);
        StringBuilder sb = new StringBuilder();
        String s = Long.toBinaryString(p);
        if (s.length() < 32) {
            for (int i = 0;i < (32-s.length());i++) {
                sb.append(0);
            }
            sb.append(s);
        } else if (s.length() == 32) {
            sb.append(s);
        }
        for (int i = 0;i < (sb.length()-8);i += 8) {
            System.out.print(Integer.parseInt(sb.substring(i,i+8),2)+".");
        }
        System.out.println(Integer.parseInt(sb.substring(sb.length()-8,sb.length()),2));
    }
    public static long ipToTen(String ip) {
        String[] arr = ip.split("\\.");
        long l = Long.parseLong(arr[0]);
        for (int i = 1;i < arr.length;i++) {
            l = l << 8;
            l += Long.parseLong(arr[i]);
        }
        return l;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            String ip10 = scanner.nextLine();
            System.out.println(ipToTen(ip));
            tenToIp(ip10);
        }
    }
}
