public class Test {
    public static void main(String[] args) {
        Integer i1 = 59;
        int i2 = 59;
        Integer i3 = Integer.valueOf(59);
        Integer i4 = new Integer(59);
        System.out.println(i1 == i3);
        System.out.println(i3 == i4);
        System.out.println(i2 == i4);
        System.out.println(i1 == i2);
    }
}
