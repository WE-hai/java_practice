import java.util.Scanner;

public class Main {
    public String toLowerCase(String str) {
        String s = str.toLowerCase();
        return s;
    }
    public static void main(String[] args) {
        Main m = new Main();
        String s = "ADSDFFG";
        System.out.println(m.toLowerCase(s));
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串（含大写）：");
        String string = scanner.nextLine();
        System.out.println(m.toLowerCase(string));
    }
}
