public class Test1 {
    private static int test() {
        int tmp = 1;
        try {
            System.out.println(tmp);
            return ++tmp;
        } catch (Exception e) {
            System.out.println(tmp);
            return ++tmp;
        } finally {
            ++tmp;
            System.out.println(tmp);
        }
    }
    public static void main(String[] args) {
        System.out.println(test());
    }
}
