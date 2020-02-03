public class Cat {
    public static void sleep() {
        System.out.println("sleep!");
    }

    public static void main(String[] args) {
        Cat.sleep();
        int x = 20;
        int y = 5;
        System.out.println(x+y + "" + (x+y)+y);
        System.out.println();

        int i = 7;
        do {
            System.out.println(--i);
            --i;
        } while (i != 0);
        System.out.println(i);
    }
}
