package 二进制中1的个数;

public class Main {
    public int NumberOf1(int n) {
        int num = 0;
        while (n != 0) {
            num++;
            n &= (n - 1);
        }
        return num;
    }
}
