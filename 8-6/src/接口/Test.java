package 接口;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student("张三", 95),
                new Student("李四", 96),
                new Student("王五", 97),
                new Student("赵六", 92),
        };
        //Arrays.sort(students);
        Student.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
