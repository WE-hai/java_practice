package DNA序列;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int n = scanner.nextInt();
            int beginId = 0;
            int GCcount = 0;
            for (int i = 0;i <= s.length()-n;i++) {
                int count = 0;
                for (int j = i;j < i+n;j++) {
                    if (s.charAt(j) == 'C' || s.charAt(j) == 'G') {
                        count++;
                    }
                }
                if (count > GCcount) {
                    beginId = i;
                    GCcount = count;
                }
            }
            System.out.println(s.substring(beginId,beginId+n));
        }
    }
}
