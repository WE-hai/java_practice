package 题目1;

import java.util.Scanner;

public class Main {
    public void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public int sort (String inData) {
        // write code here
        String[] strings = inData.split(" ");
        int count = 0;
        int[] arr = new int[strings.length];
        for (int i = 0;i < strings.length;i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        int max = arr[arr.length-1];
        for (int i = 0;i < arr.length;i++) {
            if (arr[i] < max) {
                swap(arr,i,arr.length-1);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
