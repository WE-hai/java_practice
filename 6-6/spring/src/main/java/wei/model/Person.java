package wei.model;

public class Person {
    private Duck duck;

    @Override
    public String toString() {
        return "Person{"+"duck="+duck+"}";
    }

    public void setDuck(Duck duck) {
        this.duck = duck;
    }

    public Duck getDuck() {
        return duck;
    }
}
