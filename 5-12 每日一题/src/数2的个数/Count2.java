package 数2的个数;

public class Count2 {
    public int countNumberOf2s(int n) {
        String[] arr = new String[n+1];
        int count = 0;
        for (int i = 0;i <= n;i++) {
            arr[i] = Integer.toString(i);
            if (arr[i].contains("2")) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Count2 test = new Count2();
        System.out.println(test.countNumberOf2s(10));
        System.out.println(test.countNumberOf2s(20));
    }
}
