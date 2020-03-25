import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Sort sort = new Sort();
        Random rdm = new Random(1705041107);
        int number = 20;
        int[] arr = new int[number];
        for(int i = 0; i <number; ++i){
            arr[i] = rdm.nextInt(10000) % 150;
        }
        int[]  copy = arr.clone();
        int[]  copy2 = arr.clone();
        int[]  copy3 = arr.clone();
        int[]  copy4 = arr.clone();
        int[]  copy5 = arr.clone();
        int[]  copy6 = arr.clone();
        int[]  copy7 = arr.clone();
        int[]  copy8 = arr.clone();
        int[]  copy9 = arr.clone();

        System.out.println("原 数 组\t: "+Arrays.toString(arr));
        sort.insertSort(arr);
        System.out.println("insertSort\t: " + Arrays.toString(arr));
        Arrays.sort(copy);
        System.out.println("Arrays.sort\t: " + Arrays.toString(copy));
        sort.shellSort(copy2);
        System.out.println("shellSort\t: " + Arrays.toString(copy2));
        sort.selectSort(copy3);
        System.out.println("selectSort\t: " + Arrays.toString(copy3));
        sort.heapSort(copy4);
        System.out.println("heapSort\t: " + Arrays.toString(copy4));
        sort.bubbleSort(copy5);
        System.out.println("bubbleSort\t: " + Arrays.toString(copy5));
        sort.quickSort(copy6, 0, copy6.length - 1);
        System.out.println("quickSort\t: " + Arrays.toString(copy6));
        sort.quickSortNo(copy7);
        System.out.println("quickSortNo\t: " + Arrays.toString(copy7));
        sort.mergeSort(copy8);
        System.out.println("mergeSort \t: " + Arrays.toString(copy8));
        sort.mergeSortNoR(copy9);
        System.out.println("mergeSortNo\t: " + Arrays.toString(copy9));

    }
}
