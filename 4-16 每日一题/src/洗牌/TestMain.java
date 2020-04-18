package 洗牌;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMain {
    public List<Integer> flush(List<Integer> cards, int n) {
        List<Integer> leftCards = cards.subList(0,n);
        List<Integer> rightCards = cards.subList(n,2*n);
        List<Integer> result = new ArrayList<>();
        int rightIndex,leftIndex;
        for (int i = 0; i < n; i++) {
            result.add(rightCards.get(n-i-1));
            result.add(leftCards.get(n-i-1));
        }
        for (int i = 0; i < n; i++) {
            int temp = result.get(i);
            result.set(i,result.get(2 * n - i - 1));
            result.set(2*n-i-1,temp);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            List<Integer> result = new ArrayList<>();
            for (int j = 0; j < 2*n; j++) {
                result.add(scanner.nextInt());
            }
            for (int i1 = 0; i1 < k; i1++) {
                result = new TestMain().flush(result,n);
            }
            for (int m = 0; m < result.size(); m++) {
                System.out.print(result.get(m));
                if (m != result.size() - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
