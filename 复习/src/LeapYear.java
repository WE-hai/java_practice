public class LeapYear {
    public static void leapYear(int year) {
        if (year%100 == 0) {
            //判定世纪闰年
            if (year%400 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            //普通闰年
            if (year%4 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean leap(int year) {
        if (year%100 == 0 && year%400 ==0) {
            return true;
        }
        if (year%100 != 0 && year%4 == 0) {
            return true;
        }
        return false;
    }

    public static boolean leap2(int year) {
        return ((year%100 == 0 && year%400 ==0) || (year%100 != 0 && year%4 == 0)) ? true : false;
    }

    public static void main(String[] args) {
        int year = 2000;
        leapYear(year);
        System.out.println(leap(year));
        System.out.println(leap2(year));
    }
}
