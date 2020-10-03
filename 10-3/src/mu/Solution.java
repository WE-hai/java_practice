package mu;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return dpHelper(candidates,target);
    }
    public List<List<Integer>> dpHelper(int[] candidates,int target){
        Arrays.sort(candidates);
        Set<Integer> posMap = new HashSet<>();
        for(int i = 0;i<candidates.length;++i){
            posMap.add(candidates[i]);
        }
        Map<Integer,Set<List<Integer>>> dp = new HashMap<>();
        for (int i = candidates[0];i <= target;++i){
            Set<List<Integer>> set = new HashSet<>();
            dp.put(i,set);
            if(i<candidates[0]){
                continue;
            }
            //先处理包含本值的情况
            if(posMap.contains(i)){
                set.add(Arrays.asList(i));
            }
            //再处理其他值相加的情况
            int half  =  i/2+1;
            for(int j = 0;j<candidates.length && candidates[j]<half;++j){
                Set<List<Integer>> candidate = dp.get(i-candidates[j]);
                if(!candidate.isEmpty()){
                    for (List<Integer> list:candidate){
                        List<Integer> resItem = new ArrayList<>(list);
                        resItem.add(candidates[j]);
                        resItem.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1-o2;
                            }
                        });
                        set.add(resItem);
                    }
                }
            }
        }
        Set<List<Integer>> res = dp.get(target);
        if(res == null){
            return new ArrayList<>();
        }
        return new ArrayList<>(res);
    }
}
