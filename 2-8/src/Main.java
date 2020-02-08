class DataWeap {
    int a;
    int b;
}
public class Main {
    public static void swap(DataWeap dw) {
        int tmp = dw.a;
        dw.a = dw.b;
        dw.b = tmp;
        System.out.println("swap中：a = " + dw.a + "; b = " + dw.b);
    }

    public static void main(String[] args) {
        DataWeap dw = new DataWeap();
        dw.a = 4;
        dw.b = 9;
        swap(dw);
        System.out.println("a = "+dw.a+"；b = "+dw.b);
    }
}
