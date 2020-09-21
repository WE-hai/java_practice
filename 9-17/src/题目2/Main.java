package 题目2;

public class Main {
    public int add(int a,int b) {
        try {
            return a+b;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("1234");
        return 0;
    }
    public static void main(String[] args) {
        Main test = new Main();
        System.out.println(test.add(2,8));
    }
}
