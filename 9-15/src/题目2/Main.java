package 题目2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public int[] pushIntArray (int[] arr, int pushOffset) {
        // write code here
        int[] tmp = new int[arr.length];
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length-pushOffset;i < arr.length;i++) {
            list.add(arr[i]);
        }
        for (int i = 0;i < arr.length-pushOffset;i++) {
            list.add(arr[i]);
        }
        for (int i = 0;i < list.size();i++) {
            tmp[i] = list.get(i);
        }
        return tmp;
    }
    public static void main(String[] args) {
        Main test = new Main();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(test.pushIntArray(arr, 2)));
    }
}
