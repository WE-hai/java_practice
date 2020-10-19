package 调整数组顺序使奇数在前偶数在后;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public void reOrderArray(int[] array) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0;i < array.length;i++) {
            if (array[i]%2 == 1) {
                q.offer(array[i]);
            }
        }
        for (int i = 0;i < array.length;i++) {
            if (array[i]%2 == 0) {
                q.offer(array[i]);
            }
        }
        for (int i = 0;i < array.length;i++) {
            array[i] = q.poll();
        }
    }
}
