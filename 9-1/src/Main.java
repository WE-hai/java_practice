public class Main {
    public static int binarySearch(int[] a, int x, int n) {
        if(n > 0 && x >= a[0]) {
            int left = 0, right = n-1;
            while(left < right) {
                int middle = (left + right + 1) / 2;
                if(x < a[middle]) {
                    right = middle - 1;
                } else {
                    left = middle;
                }
            }
            if(x == a[left]) {
                return left;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,39,43,45,54,64};
        System.out.println(binarySearch(arr,39,arr.length));
    }
}
