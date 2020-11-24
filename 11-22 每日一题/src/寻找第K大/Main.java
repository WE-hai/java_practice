package 寻找第K大;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public int findKth(int[] a, int n, int K) {
        // write code here
        List<Integer> list = new ArrayList();
        for(int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        Collections.sort(list);
        int index = list.size() -1;
        while(K > 1) {
            int temp = list.get(index);
            index--;
            while(list.get(index) == temp){
                index--;
            }
            K--;
        }
        return list.get(index);
    }
}
