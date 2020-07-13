public class ForDemo {
    public static void main(String[] args) {
        {
            System.out.print("打印1-10的数字：");
            for (int i = 0;i <= 10;i++) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
        {
            System.out.print("计算1-100的和：");
            int sum = 0;
            for (int i = 0;i <= 100;i++) {
                sum += i;
            }
            System.out.println(sum);
        }
        {
            System.out.print("计算5！：");
            int ret = 1;
            for (int i = 1;i <= 5;i++) {
                ret *= i;
            }
            System.out.println(ret);
        }
        {
            System.out.print("计算1!+2!+3!+4!+5!：");
            int sum = 0;
            for (int i = 1;i <= 5;i++) {
                int ret = 1;
                for (int j = 1;j < i;j++) {
                    ret *= j;
                }
                sum += ret;
            }
            System.out.println(sum);
        }

    }
}
