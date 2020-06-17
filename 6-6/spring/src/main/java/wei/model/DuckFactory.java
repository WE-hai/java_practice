package wei.model;

public class DuckFactory {
    public static Duck create() {
        Duck duck = new Duck();
        duck.setName("a");
        duck.setAge(3);
        return duck;
    }

    public Duck create2() {
        Duck duck = new Duck();
        duck.setName("b");
        duck.setAge(4);
        return duck;
    }
}
