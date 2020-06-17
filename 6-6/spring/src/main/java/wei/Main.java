package wei;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wei.model.Duck;
import wei.model.DuckStore;
import wei.model.Person;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applications.xml");
        Duck duck1 = (Duck) context.getBean("duck1");
        System.out.println(duck1);
        Duck duck1_1 = (Duck) context.getBean("duck1");
        System.out.println(duck1 == duck1_1);
        Duck duck2 = (Duck) context.getBean("duck2");
        System.out.println(duck1);
        Duck duck2_2 = (Duck) context.getBean("duck2");
        System.out.println(duck2 == duck2_2);
        DuckStore store = (DuckStore) context.getBean("duckstore");
        System.out.println(store);
        Person p1 = (Person) context.getBean(Person.class);
        System.out.println(p1);
        Duck duck3 = (Duck) context.getBean("duck3");
        System.out.println(duck3);
        Duck duck4 = (Duck) context.getBean("duck4");
        System.out.println(duck4);

    }
}
