package 逆序对;

public class Main {
    public static int count(int[] arr,int n) {
        int count = 0;
        for (int i = arr.length-1;i > 0;i--) {
            for (int j = i;j >= 0;j--) {
                if (arr[i] < arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(count(arr,8));
    }
}
