package 成绩排序;

import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
    String name;
    int grade;
    public static int flag;

    public Student(String name,int grade) {
        this.name = name;
        this.grade = grade;
    }
    @Override
    public int compareTo(Student o) {
        if (flag == 0) {
            return o.grade-grade;
        }
        return grade-o.grade;
    }
    @Override
    public String toString() {
        return name+" "+grade;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Student.flag = scanner.nextInt();
            Student[] students = new Student[n];
            for (int i = 0;i < n;i++) {
                students[i] = new Student(scanner.nextLine(),scanner.nextInt());
            }
            Arrays.sort(students);
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
