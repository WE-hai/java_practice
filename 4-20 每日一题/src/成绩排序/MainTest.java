package 成绩排序;

import java.util.Arrays;
import java.util.Scanner;

public class MainTest
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt())
        {
            int n = sc.nextInt();
            Student.flag = sc.nextInt();

            Students[] stu = new Students[n];
            for (int i = 0; i < n; i++)
                stu[i] = new Students(sc.next(), sc.nextInt());

            Arrays.sort(stu);
            for (Students each : stu)
                System.out.println(each);
        }
        sc.close();
    }

}

class Students implements Comparable<Students>
{
    String name;
    int score;
    public static int flag;

    public Students(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    @Override
public int compareTo(Students o) {
    if (flag == 0)
        return o.score - score;
    return score - o.score;
}

@Override
public String toString()
{
    return name + " " + score;
}

}