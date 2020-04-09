package 机器人走方格;

public class MainTest {
    public static int countWay(int x,int y) {
        if (x+y > 12) {
            return -1;
        }
        if (x == 1 || y == 1) {
            return 1;
        }
        return countWay(x-1,y) + countWay(x,y-1);
    }

    public static void main(String[] args) {
        System.out.println(countWay(2,2));
    }
}
