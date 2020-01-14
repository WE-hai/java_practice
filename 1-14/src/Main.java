public class Main {
    public static void main(String[] args) {
        System.out.println(5 & 9); // 将输出1
        System.out.println(5 | 9); // 将输出13
        System.out.println(~-5); // 将输出4
        System.out.println(5 ^ 9); // 将输出12
        System.out.println(5 << 2); // 输出20
        System.out.println(-5 << 2); // 输出-20
        System.out.println(-5 >> 2); // 输出-2
        System.out.println(-5 >>> 2); // 输出1073741822
        System.out.println();
        System.out.println("5是否大于 4.0：" + (5 > 4.0)); // 输出true
        System.out.println("5和5.0是否相等：" + (5 == 5.0)); // 输出true
        System.out.println("97和'a'是否相等：" + (97 == 'a')); // 输出true
        System.out.println("true和false是否相等：" + (true == false)); // 输出false
        Main t1 = new Main();
        Main t2 = new Main();
        // t1和t2是同一个类的两个实例的引用，所以可以比较，
        // 但t1和t2引用不同的对象，所以返回false
        System.out.println("t1是否等于t2：" + (t1 == t2));
        // 直接将t1的值赋给t3，即让t3指向t1指向的对象
        Main t3 = t1;
        // t1和t3指向同一个对象，所以返回true
        System.out.println("t1是否等于t3：" + (t1 == t3));
    }
}
