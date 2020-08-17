package b2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                if (strings[i] != null) {
                    if (strings[i].equals("undo") || strings[i].equals("redo")) {
                        strings[i] = "";
                    }
                    if (strings[i].equals("undo")) {
                        strings[i-1] = " ";
                    }
                }
            }
            for (int i = 0;i < strings.length;i++) {
                sb.append(strings[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
