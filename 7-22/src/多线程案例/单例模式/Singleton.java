package 多线程案例.单例模式;

public class Singleton {
    //饿汉模式
    private static Singleton instance = new Singleton();
    private Singleton() {

    }
    public static Singleton getInstance() {
        return instance;
    }
}

class Singleton2 {
    //懒汉模式-单线程版
    private static Singleton2 instance2 = null;
    private Singleton2() {

    }
    public static Singleton2 getInstance() {
        if (instance2 == null) {
            instance2 = new Singleton2();
        }
        return instance2;
    }
}

class Singleton3 {
    //懒汉模式-多线程版-性能低
    private static Singleton3 instance3 = null;
    private Singleton3() {

    }
    public synchronized static Singleton3 getInstance() {
        if (instance3 == null) {
            instance3 = new Singleton3();
        }
        return instance3;
    }
}

class Singleton4 {
    //懒汉模式-多线程版-二次判断-性能高
    private static volatile Singleton4 instance4 = null;
    private Singleton4() {

    }
    public static Singleton4 getInstance() {
        if (instance4 == null) {
            synchronized (Singleton4.class) {
                if (instance4 == null) {
                    instance4 = new Singleton4();
                }
            }
        }
        return instance4;
    }
}