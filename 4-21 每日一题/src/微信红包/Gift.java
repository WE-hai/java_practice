package 微信红包;

import java.util.Arrays;

public class Gift {
    //如果一个数出现次数超过一半了，
    // 排序过后，必然排在中间，则最后遍历整个数组查看是否符合即可。
    public int getValue(int[] gifts,int n) {
        Arrays.sort(gifts);
        int num = gifts[n/2];
        int count = 0;
        for (int i = 0;i < n;i++) {
            if (num == gifts[i]) {
                count++;
            }
        }
        if (count <= n/2) {
            return 0;
        } else {
            return num;
        }
    }
}
