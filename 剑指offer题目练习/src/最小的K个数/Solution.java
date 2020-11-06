package 最小的K个数;

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if(k <= 0 || k > input.length) {
            return result;
        }
        //初次排序，完成k个元素的排序
        for(int i = 1; i< k; i++){
            int j = i-1;
            int unFindElement = input[i];
            while(j >= 0 && input[j] > unFindElement){
                input[j+1] = input[j];
                j--;
            }

            input[j+1] = unFindElement;
        }
        //遍历后面的元素 进行k个元素的更新和替换
        for(int i = k; i < input.length; i++){
            if(input[i] < input[k-1]){
                int newK = input[i];
                int j = k-1;
                while(j >= 0 && input[j] > newK){
                    input[j+1] = input[j];
                    j--;
                }
                input[j+1] = newK;
            }
        }
        //把前k个元素返回
        for(int i = 0; i < k; i++)
            result.add(input[i]);
        return result;
    }
}
