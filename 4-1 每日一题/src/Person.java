public class Person {
    private String name = "person";
    int age;
}
class Child extends Person {
    private String grade;

    public static void main(String[] args) {
        Person a = new Child();
        System.out.println(((Child) a).grade);
    }
}
