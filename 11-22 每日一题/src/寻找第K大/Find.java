package 寻找第K大;

public class Find {
    public int findKth(int[] a, int n, int K) {
        return find(a, 0, n - 1, K);
    }

    //递归寻找数组中第K大的元素
    private int find(int[] a, int low, int high, int K) {
        int pivot = partition(a, low, high);
        if (pivot + 1 < K) {//中轴位置少于K个，在右子数组中继续查找
            return find(a, pivot + 1, high, K);
        } else if (pivot + 1 > K) {//中轴位置大于K个，在左子数组中继续查找
            return find(a, low, pivot - 1, K);
        } else {//中轴元素正好是第K大的元素
            return a[pivot];
        }
    }

    //将数组划分为两部分，左边较大，右边较小
    private int partition(int[] a, int low, int high) {
        // 将数组首元素作为每一轮比较的基准
        int pivotValue = a[low];
        while (low < high) {
            // 从右往左扫描，直到遇到比基准元素小的元素
            while (low < high && a[high] <= pivotValue) {
                --high;
            }
            // 将右子数组中不合格的元素放到左边不合格元素的位置（原元素已经移走）
            a[low] = a[high];
            // 从左往右扫描，直到遇到比基准元素大的元素
            while (low < high && a[low] >= pivotValue) {
                ++low;
            }
            // 将左子数组中不合格的元素放到左边不合格元素的位置（原元素已经移走）
            a[high] = a[low];
        }
        // 将基准元素放到中间位置
        a[low] = pivotValue;
        // 返回数组的中轴位置
        return low;
    }
}
