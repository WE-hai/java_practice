public class ReferenceArrayTest {
    public static void main(String[] args) {
        Person[] students;
        students = new Person[2];
        Person zhang = new Person();
        zhang.age = 18;
        zhang.height = 180;
        Person li = new Person();
        li.age = 20;
        li.height = 187;
        students[0] = zhang;
        students[1] = li;
        li.info();
        students[1].info();
    }
}
