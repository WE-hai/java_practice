import java.util.Scanner;

class MyDateTime {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	
	private static final int[] DAY_OF_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public MyDateTime() {
		year = 1970;
		month = 1;
		day = 1;
	}
	
	public MyDateTime(int year,int month,int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public static boolean leapYear(int year) {
		if((year%4 == 0 && year%100 != 0)||year%400 == 0) {
			return true;
		}
		return false;
	}
	
	public static int getDayOfMonth(int year,int month) {
		if(month != 2) {
			return DAY_OF_MONTH[month - 1];
		}  
		if(leapYear(year)) {
			return 29;
		} else {
			return 28;
		}
	}
	
	public MyDateTime(int year,int month,int day,int hour,int minute,int second) {
		if(year < 1970) {
			System.out.println("不支持年份！");
			return;
		}
		if(month > 12||month < 1) {
			System.out.println("不支持月份！");
			return;
		}
		if(day < 1||day > getDayOfMonth(year,month)) {
			System.out.println("不支持天数！");
			return;
		}
		if(hour < 0 || hour >= 24) {
			System.out.println("不支持小时数！");
			return;
		}
		if(minute < 0||minute >= 60) {
			System.out.println("不支持分钟数！");
			return;
		}
		if(second < 0||second >= 60) {
			System.out.println("不支持秒数！");
			return;
		}
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	@Override
	public String toString() {
		return String.format("%04d-%02d-%02d %02d：%02d：%02d", year, month, day,hour,minute,second);
	}
	
	public void addDays(int days) {
		day += days;
		while(day > getDayOfMonth(year,month)) {
			day -= getDayOfMonth(year,month);
			month += 1;
			if(month > 12) {
				year += 1;
				month = 1;
			}
		}
	}
	
	public void subDays(int days) {
		day -=days;
		while(day <= 0) {
			month -= 1;
			if(month == 0) {
				year -=1;
				month = 12;
			}
		}
		day += getDayOfMonth(year,month);
	}
	
	public void addSeconds(int seconds) {
		second += seconds;
		while(second > 60) {
			minute += 1;
			if(minute > 60) {
				hour += 1;
				minute = 0;
			}
			if(hour > 24) {
				hour = 0;
			}
		}
	}
	
	public void subSeconds(int seconds) {
		second -= seconds;
		while(second < 0) {
			minute -= 1;
			if(minute < 0) {
				hour -= 1;
				minute = 59;
			}
			if(hour > 24) {
				hour = 0;
			}
		}
		second += 60;
	}
}

public class Practice {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入年份：");
		int y = scanner.nextInt();
		System.out.println("请输入月份：");
		int mon = scanner.nextInt();
		System.out.println("请输入日：");
		int d = scanner.nextInt();
		System.out.println("请输入时：");
		int h = scanner.nextInt();
		System.out.println("请输入分：");
		int min = scanner.nextInt();
		System.out.println("请输入秒：");
		int s = scanner.nextInt();
		MyDateTime t = new MyDateTime(y,mon,d,h,min,s);
		System.out.println("***********************");
		System.out.println("****  1、增加天数  ****");
		System.out.println("****  2、减少天数  ****");
		System.out.println("****  3、增加秒数  ****");
		System.out.println("****  4、减少秒数  ****");
		System.out.println("***********************");
		System.out.println("请输入选择：");
		int input = scanner.nextInt();
		switch(input) {
			case 1:
				System.out.println("请输入增加的天数：");
				int a = scanner.nextInt();
				t.addDays(a);
				System.out.println(t);
				break;
			case 2:
				System.out.println("请输入减少天数：");
				int b = scanner.nextInt();
				t.subDays(b);
				System.out.println(t);
				break;
			case 3:
				System.out.println("请输入增加秒数：");
				int c = scanner.nextInt();
				t.addSeconds(c);
				System.out.println(t);
				break;
			case 4:	
				System.out.println("请输入减少秒数：");
				int g = scanner.nextInt();
				t.subSeconds(g);
				System.out.println(t);
				break;
			default:
				break;
		}
			
	}
}