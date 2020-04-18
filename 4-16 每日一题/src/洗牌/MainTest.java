package 洗牌;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// 使用Scanner来获取键盘输入
        // 第一次输入的是T
        // T：要洗牌的牌组数量
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            // 第二次输入的是n和k
            // n：2n即牌的数量
            // k：洗牌的次数
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            // 获得牌组cards，并分成两堆cards1和cards2
            ArrayList<Integer> cards = new ArrayList<>();
            ArrayList<Integer> cards1 = new ArrayList<>();
            ArrayList<Integer> cards2 = new ArrayList<>();
            // 获得牌组cards所有数
            for (int j = 0; j < 2 * n; j++) {
                cards.add(scanner.nextInt());
            }
            Collections.reverse(cards);// 将牌组顺序翻转，便于洗牌
            for (int x = 0; x < k; x++) {
                cards1.clear();
                cards2.clear();
                //将下半堆放入cards1
                for (int j = 0; j < n; j++) {
                    cards1.add(cards.get(j));
                }
                // 将上半堆放入cards2
                for (int j = n; j < 2 * n; j++) {
                    cards2.add(cards.get(j));
                }
                // 洗牌过程
                cards.clear();
                for (int j = 0; j < n; j++) {
                    cards.add(cards1.get(j));
                    cards.add(cards2.get(j));
                }
            }

            Collections.reverse(cards);// 再把牌组顺序反转为正常顺序
            System.out.println(
                    cards.toString()
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", ""));
        }
    }
}
