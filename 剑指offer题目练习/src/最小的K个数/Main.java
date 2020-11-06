package 最小的K个数;

import java.util.*;

public class Main {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length >= k && k > 0) {
            Arrays.sort(input);
            for(int i = 0;i < k;i++) {
                result.add(new Integer(input[i]));
            }
        }
        return result;
    }
}
