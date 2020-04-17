package 尼科彻斯定理;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {
    public static String get(int m) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            sum += i;
        }
        int a = 1;
        list.add(1);
        for (int i = 1; i < sum; i++) {
            a += 2;
            list.add(a);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = list.size() - m; i < list.size() - 1; i++) {
            stringBuffer.append(list.get(i));
            stringBuffer.append('+');
        }
        stringBuffer.append(list.get(list.size() - 1));
        return stringBuffer.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        String s = get(m);
        System.out.println(s);
    }
}
