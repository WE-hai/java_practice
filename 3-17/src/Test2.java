import java.util.Random;

public class Test2 {

    public static void main(String[] args) {
        Sort sort2 = new Sort();
        Random rdm = new Random(1705041107);
        int number = 100000;
        int[] arr = new int[number];
        for(int i = 0; i <number; ++i){
            arr[i] = rdm.nextInt();
        }
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();
        int[] arr5 = arr.clone();
        int[] arr6 = arr.clone();
        int[] arr7 = arr.clone();
        int[] arr8 = arr.clone();


        long begin = System.nanoTime();
        sort2.insertSort(arr);
        long end = System.nanoTime();
        System.out.printf("insertSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.shellSort(arr2);
        end = System.nanoTime();
        System.out.printf("shellSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.selectSort(arr3);
        end = System.nanoTime();
        System.out.printf("selectSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.heapSort(arr4);
        end = System.nanoTime();
        System.out.printf("heapSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.bubbleSort(arr5);
        end = System.nanoTime();
        System.out.printf("bubbleSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.quickSort(arr6, 0, arr6.length - 1);
        end = System.nanoTime();
        System.out.printf("quickSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.quickSortNo(arr7);
        end = System.nanoTime();
        System.out.printf("quickSortNoR time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        //sort2.merge(arr8);
        end = System.nanoTime();
        System.out.printf("mergeSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);


        System.out.println("数据已经有序： ");
        begin = System.nanoTime();
        sort2.insertSort(arr);
        end = System.nanoTime();
        System.out.printf("insertSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.shellSort(arr2);
        end = System.nanoTime();
        System.out.printf("shellSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.selectSort(arr3);
        end = System.nanoTime();
        System.out.printf("selectSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.heapSort(arr4);
        end = System.nanoTime();
        System.out.printf("heapSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.bubbleSort(arr5);
        end = System.nanoTime();
        System.out.printf("bubbleSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.quickSort(arr6, 0, arr6.length - 1);
        end = System.nanoTime();
        System.out.printf("quickSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        sort2.quickSortNo(arr7);
        end = System.nanoTime();
        System.out.printf("quickSortNo time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        //sort2.merge(arr8);
        end = System.nanoTime();
        System.out.printf("mergeSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);
    }
}
