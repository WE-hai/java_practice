package 计算日期到天数的转换;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNext()){
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int res = dayOfYear(year,month,day);
            System.out.println(res);
        }
    }
    public static int dayOfYear(int year,int month,int day){
        switch (month){
            case 12:
                day += 30;
            case 11:
                day += 31;
            case 10:
                day += 30;
            case 9:
                day += 31;
            case 8:
                day += 31;
            case 7:
                day += 30;
            case 6:
                day += 31;
            case 5:
                day += 30;
            case 4:
                day += 31;
            case 3:{
                if (year%4 == 0 && year%100!=0){
                    day += 29;
                }else
                    day += 28;
            }
            case 2 :
                day += 31;
            case 1:
                day += 0;
        }
        return day;
    }
}
