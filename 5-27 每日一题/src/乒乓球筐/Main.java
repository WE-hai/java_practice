package 乒乓球筐;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            List<Character> A = new ArrayList<>();
            List<Character> B = new ArrayList<>();
            for (int i = 0;i < s1.length();i++) {
                A.add(s1.charAt(i));
            }
            for (int i = 0;i < s2.length();i++) {
                B.add(s2.charAt(i));
            }
            for (int i = 0;i < B.size();i++) {
                if (A.contains(B.get(i))) {
                    A.remove(A.get(A.indexOf(B.get(i))));
                    B.remove(i);
                    i--;
                }
            }
            if (B.size() == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
