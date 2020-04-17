package 尼科彻斯定理;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String get(int m) {
        int sum = 0;
        for (int i = 1;i <= m;i++) {
            sum += i;
        }
        int sumSub = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1;i < sum;i++) {
            sumSub += 2;
            list.add(sumSub);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size()-m;i < list.size()-1;i++) {
            sb.append(list.get(i));
            sb.append("+");
        }
        sb.append(list.get(list.size()-1));
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        String s = get(m);
        System.out.println(s);
    }
}
