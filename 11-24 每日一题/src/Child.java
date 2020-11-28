
class Person {
    String name = "person";
    int age = 0;
}
public class Child extends Person {
    String grade;

    public static void main(String[] args) {
        Person s = new Child();
        System.out.println(s.name);
    }
}

