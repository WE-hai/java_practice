public class Person {
    private String name;
    private int age;

    public void setName(String name) {
        if (name.length() > 6 || name.length() < 2) {
            System.out.println("人名不符合要求");
            return;
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("年龄不符合要求");
            return;
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return this.age;
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.age = -12;
        p.setAge(-13);
        System.out.println(p.getAge());
        p.setAge(23);
        System.out.println(p.getAge());
        p.setName("whb");
        System.out.println(p.getName());
    }
}
