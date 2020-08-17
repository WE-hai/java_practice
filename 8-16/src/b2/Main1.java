package b2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String str = null;
            if (s.contains(" undo redo ")) {
                str = s.replace("undo redo", "");
                System.out.println(str);
            }

        }
    }
}
