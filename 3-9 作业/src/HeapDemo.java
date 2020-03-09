import java.util.*;

public class HeapDemo {
    //寻找和最小的k对数字
    public int twoSum(int[] arr) {
        return arr[0] + arr[1];
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        LinkedList<List<Integer>> resList = new LinkedList<>();
        PriorityQueue<int[]> pQ = new PriorityQueue<>((e1, e2) -> twoSum(e2)-twoSum(e1));
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int[] arr = new int[]{n1, n2};
                pQ.add(arr);
                if (pQ.size() > k)
                    pQ.poll();
            }
        }
        while (!pQ.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int[] arr = pQ.poll();
            list.add(arr[0]);
            list.add(arr[1]);
            resList.add(list);
        }
        return resList;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null || nums1.length <= 0 || nums2.length <= 0 || k <= 0){
            return new ArrayList<>(1);
        }
        //总体思路就是利用 nums1、nums2 是 有序数组的 ，那就肯定是堆
        //1.扫描一遍，nums1 的 前 k个数到 nums2的前 N 个数的排列，O(K*K),因为从极端情况下考虑，前 K 个的出现范围是 K * K 中
        return  findKPairs(nums1, nums2, k);
    }

    private List<List<Integer>> findKPairs(int[] nums1, int[] nums2, int k) {
        int count = 0, len1 = nums1.length, len2 = nums2.length, i = 0, j = 0 ;
        List<List<Integer>> ans = new ArrayList<>(k);
        // 每次遍历一遍 nums2，才对 i++
        while(count < k && i < len1){
            List<Integer> temp = new ArrayList<>(2);
            temp.add(nums1[i]);
            temp.add(nums2[j]);
            ans.add(temp);
            count++;
            if(++j >= len2){
                j = 0;
                i++;
            }
        }
        if(count < k){
            return ans;
        }
        for(int m = (k >> 1) - 1; m >= 0; m--){
            adjustHeap(ans, m ,k);
        }
        List<Integer> temp ;
        for(; i < len1; i++){
            for(;j<= len2; j++){
                if(j == len2 || (nums1[i] + nums2[j] >= ans.get(0).get(0) + ans.get(0).get(1))){
                    if(j == 0){
                        return ans;
                    }
                    j = 0;
                    break;
                }
                //ans.get是返回的一个镜像
                temp = ans.get(0);
                temp.set(0, nums1[i]);
                temp.set(1, nums2[j]);
                ans.set(0, temp);
                adjustHeap(ans, 0 ,k);
            }
        }
        return ans;
    }

    private void adjustHeap(List<List<Integer>> lists, int be, int end) {
        List<Integer> temp = lists.get(be), list1;
        for(int k =  1 + (be << 1) ; k < end ; k = 1 + (k << 1)){
            list1 = lists.get(k);
            if(k + 1 < end && list1.get(0) + list1.get(1) < lists.get(k + 1).get(0) + lists.get(k + 1).get(1)){
                list1 = lists.get(++k);
            }

            if(list1.get(0) + list1.get(1) <= temp.get(0) + temp.get(1)){
                break;
            }
            lists.set(be, list1);
            be = k;
        }
        lists.set(be, temp);
    }

    public List<List<Integer>> kSmallestPairs3(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>>queue=new PriorityQueue<>(k,new Comparator<List<Integer>>() {

            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                // TODO Auto-generated method stub
                int sum1=0,sum2=0;
                for(int i=0;i<o1.size();i++) {
                    sum1+=o1.get(i);
                }
                for(int i=0;i<o1.size();i++) {
                    sum2+=o2.get(i);
                }
                return sum2-sum1;
            }
        });
        for(int i=0;i<nums1.length;i++) {
            for(int j=0;j<nums2.length;j++) {
                List<Integer>list=new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                if(queue.size()<k) {

                    queue.add(list);
                }else {
                    if(queue.comparator().compare(list, queue.peek())>0) {
                        queue.remove();
                        queue.add(list);
                    }
                }
            }
        }
        List<List<Integer>>lists=new ArrayList<>();
        while (!queue.isEmpty()) {
            lists.add(0,queue.remove());

        }
        return lists;
    }

    //最后一块石头的重量
    public static int lastStoneWeight(int[] stones){
        int weight = 0;
        for(int i=0;i<stones.length-1;i++){
            Arrays.sort(stones);
            weight = stones[stones.length-1] - stones[stones.length-2];
            stones[stones.length-2] = 0;
            stones[stones.length-1] = weight;
        }
        return stones[stones.length-1];
    }
    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for(int i : stones)
            maxpq.offer(i);
        while(maxpq.size() > 1) {
            int y = maxpq.poll();
            int x = maxpq.poll();
            if(x != y)
                maxpq.offer(y - x);
        }
        if(maxpq.isEmpty()) return 0;
        return maxpq.peek();
    }
}

class Data {
    int position;
    int speed;
    Data(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }private boolean isMeet(Data data1, Data data2, int target) {
        if (data1.speed <= data2.speed) {
            return false;
        }

        double t = (data2.position - data1.position) * 1.0 / (data1.speed - data2.speed);
        return data1.speed * t + data1.position <= target;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        if (len == 0) {
            return 0;
        }
        Data[] datas = new Data[len];

        for (int i = 0; i < len; i++) {
            datas[i] = new Data(position[i], speed[i]);
        }

        Arrays.sort(datas, Comparator.comparingInt(o -> o.position));

        int ans = 1;
        Data frontCar = datas[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (!isMeet(datas[i], frontCar, target)) {
                ans++;
                frontCar = datas[i];
            }
        }

        return ans;
    }
}

