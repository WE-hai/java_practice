package 数组中出现次数超过一半的数字;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        for (int i = 0;i < array.length;i++) {
            int count = 0;
            for (int j = 0;j < array.length;j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count > (array.length/2)) {
                return array[i];
            }
        }
        return 0;
    }
}
