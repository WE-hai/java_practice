import java.util.Scanner;
public class Account {	
				public int id;
				public int password;
				public String name;
				public int money;	
public Account(int id, int password, String name, int money) {
	this.id = id;
	this.password = password;
	this.name = name;
	this.money = money;
	}	
//	有一个方法show()，显示账户的账号、姓名和余额信息	
public void show(){
	System.out.println("账户：" + id);
	System.out.println("姓名：" + name);
	System.out.println("余额：" + money);
	}	
/*有一个取款方法 takeMoney()，先让用户输入密码验证,密码正确后输入取款金额，取款成功后余额减除相应的金额*/	
public void takeMoney(){
	while(true){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入密码进行验证！");
		int pass = sc.nextInt();
		if(pass == password){
		System.out.println("请输入需要取款的金额：");
		int withdrawals = sc.nextInt();
		if(withdrawals <= money) {
			money= money-withdrawals;
			System.out.println("余额为：" + money);
		}else {
			System.out.println("当前余额不足" );
	}
		}else{
			System.out.println("你输入的密码有误，请重新输入！");
		}
		break;
	}
}	
//	有一个存款方法saveMoney(int money)，存款是直接传入存款金额，账户余额增加相应的金额		
public void saveMoney(int a){
			System.out.println("请输入你要存款的金额");
			Scanner M = new Scanner(System.in);
			int moneys=M.nextInt();
			money = money+moneys;
			System.out.println("此次存款为:" + moneys);
			System.out.println("账户余额为：" + money);
		}
public static void main(String[] args) {
		Account acc = new Account(10010,123456,"李静",100000);
/*	acc.id = 10010;acc.name = "李静";acc.money = 100000;acc.password = 123456;*/	
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入需要执行的操作");
		System.out.println("***1银行账户信息***");
		System.out.println("***2取款操作***");
		System.out.println("***3存款操作***");
		System.out.println("***4退出系统***");	
		int s = sc.nextInt();
		switch(s) {
				case 1:System.out.println("***银行账户信息***");		
				acc.show();
				break;
				case 2:
				System.out.println("***取款操作***");
				acc.takeMoney();
				break;
				case 3:
				System.out.println("***存款操作***");
				acc.saveMoney(1000);
				break;
				case 4:
				System.exit(0);
				break;
			}
	}
}
