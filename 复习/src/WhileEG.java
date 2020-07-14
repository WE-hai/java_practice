public class WhileEG {
    public static void main(String[] args) {
        {
            System.out.print("输出1~10：");
            int num = 1;
            while (num <= 10) {
                System.out.print(num + " ");
                num++;
            }
        }
        System.out.println();

        {
            System.out.print("计算1~100的和：");
            int n = 1;
            int sum = 0;
            while (n <= 100) {
                sum += n;
                n++;
            }
            System.out.println(sum);
        }

        {
            System.out.print("计算5！：");
            int n = 1;
            int fac = 1;
            while (n <= 5) {
                fac *= n;
                n++;
            }
            System.out.println(fac);
        }

        {
            System.out.print("计算1！+2！+3！+4！+5！：");
            int num = 1;
            int sum = 0;
            //外层循环负责阶乘的和
            while (num <= 10) {
                int facRet = 1;
                int tmp = 1;
                //里层循环负责完成阶乘的细节
                while (tmp <= num) {
                    facRet *= tmp;
                    tmp++;
                }
                sum += facRet;
                num++;
            }
            System.out.println(sum);
        }

        {
            int n = 1;
            while (n <= 10) {
                System.out.print(n+" ");
                n++;
            }
        }

        {
            int n = 1;
            do {
                System.out.print(n+" ");
                n++;
            } while (n <= 10);
        }
    }
}
