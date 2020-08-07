package 接口;

public class Student implements Comparable {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        if (this.score > s.score) {
            return -1;
        } else if (this.score < s.score) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void sort(Comparable[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1].compareTo(array[cur]) > 0) {
                    // 说明顺序不符合要求, 交换两个变量的位置
                    Comparable tmp = array[cur - 1];
                    array[cur - 1] = array[cur];
                    array[cur] = tmp;
                }
            }
        }
    }
}
