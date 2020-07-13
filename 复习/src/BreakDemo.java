public class BreakDemo {
    public static void main(String[] args) {
        int n = 100;
        while (n <= 200) {
            if (n % 3 == 0) {
                System.out.println("找到3的倍数："+n);
                break;
            }
            n++;
        }
    }
}
