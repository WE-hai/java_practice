import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sort test = new Sort();
        Search test1 = new Search();
        int[] arr1 = {3,1,4,6,22,34,12,9};
        int[] arr2 = {3,1,4,6,22,34,12,9};
        int[] arr3 = {3,1,4,6,22,34,12,9};
        int[] arr4 = {3,1,4,6,22,34,12,9};
        int[] arr5 = {3,1,4,6,22,34,12,9};
        int[] arr6 = {3,1,4,6,22,34,12,9};
        test.bubbleSort1(arr1);
        System.out.println(Arrays.toString(arr1));
        test.bubbleSort2(arr2);
        System.out.println(Arrays.toString(arr2));
        test.quickSort(arr3,0,arr3.length-1);
        System.out.println(Arrays.toString(arr3));
        test.merge(arr4);
        System.out.println(Arrays.toString(arr4));
        System.out.println(test1.binarySearch(arr5,0, arr5.length-1,6));
        System.out.println(test1.binarySearchNoR(arr6,9));
    }
}
