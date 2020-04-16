package 另类加法;

public class Main {
    public static int add(int A,int B) {
        //位的异或运算跟求'和'的结果一致：
        //异或 1^1=0 1^0=1 0^0=0
        //求和 1+1=0 1+0=1 0+0=0
        //位的与运算跟求'进位‘的结果一致：
        //位与 1&1=1 1&0=0 0&0=0
        //进位 1+1=1 1+0=0 0+0=0
        int a,b;
        while(B != 0) {
            a = A^B;
            b = (A & B) << 1;
            A = a;
            B = b;
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(add(1,2));
    }
}
