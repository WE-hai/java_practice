package 百万富翁问题;

public class Main {
    public static void main(String[] args) {
        int million = 10*30;
        int strange = 1;
        int s = 1;
        for (int i = 1;i < 30;i++) {
            s *= 2;
            strange += s;
        }
        System.out.println(million);
        System.out.println(strange);
    }
}
