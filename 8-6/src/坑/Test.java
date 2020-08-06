package 坑;

class B {
    public B() {
        // do nothing
        func();
    }
    public void func() {
        System.out.println("B.func()");
    }
}
class D extends B {
    private int num = 1;
    @Override
    public void func() {
        System.out.println("D.func() " + num);
    }
}
public class Test {
    public static void main(String[] args) {
        D d = new D();
    }
}
//构造 D 对象的同时, 会调用 B 的构造方法.
//B 的构造方法中调用了 func 方法, 此时会触发动态绑定, 会调用到 D 中的 func
//此时 D 对象自身还没有构造, 此时 num 处在未初始化的状态, 值为 0.
//结论: "用尽量简单的方式使对象进入可工作状态", 尽量不要在构造器中调用方法(如果这个方法被子类重写, 就会触发
//动态绑定, 但是此时子类对象还没构造完成), 可能会出现一些隐藏的但是又极难发现的问题.
