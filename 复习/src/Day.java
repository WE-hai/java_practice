import java.util.Scanner;

public class Day {
    public static void isDay(int day) {
        switch (day) {
            case 1 :
                System.out.println("星期一 Monday");
                break;
            case 2 :
                System.out.println("星期二 Tuesday");
                break;
            case 3 :
                System.out.println("星期三 Wednesday");
                break;
            case 4 :
                System.out.println("星期四 Thursday");
                break;
            case 5 :
                System.out.println("星期五 Friday");
                break;
            case 6 :
                System.out.println("星期六 Saturday");
                break;
            case 7 :
                System.out.println("星期日 Sunday");
                break;
            default:
                System.out.println("错误");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        isDay(day);
    }
}
