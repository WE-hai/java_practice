public class Test {
    static boolean foo(char c) {
        System.out.print(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        //for(条件1；条件2；条件3) {
        //    语句
        //}
        //for循环执行顺序：条件1 -> 条件2 -> 语句 -> 条件3 -> 条件2 -> 语句  ->  条件3 -> 条件2
        for (foo('A');foo('B') && (i < 2);foo('C')) {
            i++;
            foo('D');
        }
    }
}
