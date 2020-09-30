import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.length() == 0 || s == null) {
                return;
            }
            if (s.length() > 50) {
                System.out.println(0);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < s.length();i++) {
                if (s.charAt(i) > '0' && s.charAt(i) <= '9') {
                    sb.append((char)(s.charAt(i)-1));
                }else if (s.charAt(i) == '0') {
                    sb.append('9');
                }else if (s.charAt(i) > 'a' && s.charAt(i) <= 'z') {
                    sb.append((char)(s.charAt(i)-32-1));
                }else if (s.charAt(i) == 'a') {
                    sb.append('Z');
                }else if (s.charAt(i) > 'A' && s.charAt(i) <= 'Z') {
                    sb.append((char)(s.charAt(i)+32-1));
                }else if (s.charAt(i) == 'A') {
                    sb.append('z');
                } else {
                    continue;
                }
            }
            String str = sb.toString();
            System.out.println(str);
        }
    }
}
