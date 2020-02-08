public class Swap {
    public static void swap(int a,int b) {
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("swap中：a = " + a + "; b = " + b);
    }

    public static void main(String[] args) {
        int a = 7;
        int b = 9;
        swap(a,b);
        System.out.println("a = "+a+"；b = "+b);
    }
}
