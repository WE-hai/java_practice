package 编程题1;

public class Main {
    public int daycost (int len, int m, int n) {
    // write code here
        /*
        int day = 0;
        while (len > 0) {
            int cur = len;
            len = cur-m;
            day++;
            if (len <= 0) {
                return day;
            } else {
                int night = len;
                len = night+n;
            }
        }
        return day;
        */
        int day = 0;
        if (len <= m) {
            return 1;
        }
        while (len > 0) {
            len = len-m;
            if (len <= 0) {
                day++;
                return day;
            } else {
                len = len+n;
            }
        }
        return day;
    }
    public static void main(String[] args) {
        Main test = new Main();
        int a = test.daycost(10,5,2);
        System.out.println(a);
    }
}
