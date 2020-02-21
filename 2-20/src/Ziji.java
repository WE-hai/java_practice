import java.util.ArrayList;
import java.util.List;

public class Ziji {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Ziji test = new Ziji();
        int[] arr = {1,4,6,3};
        System.out.println(test.subsets(arr));
    }
}
