public class Search {
    public int binarySearch(int[] arr,int left,int right,int n) {
        if (left > right) {
            return -1;
        }
        int mid = (left+right)/2;
        if (arr[mid] > n) {
            return binarySearch(arr,left,mid-1,n);
        }
        if (arr[mid] < n) {
            return binarySearch(arr,mid+1,right,n);
        }
        return mid;
    }

    public int binarySearchNoR(int[] arr,int n) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] > n) {
                right = mid-1;
            } else if (arr[mid] < n) {
                left = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
