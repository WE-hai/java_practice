package 调整数组顺序使奇数在前偶数在后;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void reOrderArray(int [] array) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0;i < array.length;i++) {
            if (array[i]%2 == 0) {
                list1.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }
        for (int i = 0;i < list2.size();i++) {
            array[i] = list2.get(i);
        }
        for (int i = 0;i < list1.size();i++) {
            array[list2.size()+i] = list1.get(i);
        }
    }
}
