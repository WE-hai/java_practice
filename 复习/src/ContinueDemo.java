public class ContinueDemo {
    public static void main(String[] args) {
        int n = 100;
        while (n <= 200) {
            if (n%3 != 0) {
                n++;
                continue;
            }
            System.out.println("找到3东的倍数："+n);
            n++;
        }
    }
}
