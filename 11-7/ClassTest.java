public class ClassTest{
	public static void main(String[] args){
		Fruit c=new Fruit("橘子",1000);
		System.out.println("水果名字:"+c.FruitName);
		System.out.println("投入:"+c.input);
		int get1=c.gain();
		System.out.println("收益:"+get1);
		Apple app=new Apple("苹果",12000,200);
		System.out.println("水果名字:"+app.FruitName);
		System.out.println("投入:"+app.input);
		System.out.println("缴纳费:"+app.money);
		int get2=app.gain();
		System.out.println("收益:"+get2);
		Banana ban=new Banana("香蕉",12000);
		System.out.println("水果名字:"+ban.FruitName);
		System.out.println("投入:"+ban.input);
		int get3=ban.gain();
		System.out.println("收益:"+get3);
		
		Fruit[] coco=new Fruit[3];
		Fruit melon=new Fruit("西瓜",10000);
		Fruit coconut=new Fruit ("椰子",12000);
		Fruit yuan=new Fruit("桂圆",13456);
		coco[0]=melon;
		coco[1]=coconut;
		coco[2]=yuan;
		for(int w=0;w<coco.length;w++){
			System.out.println(coco[w].FruitName+"的收益是："+coco[w].gain());
		}
		}
		
	}

class Fruit{
	String FruitName;
	int input;
	Fruit(String a,int b){
		FruitName=a;
		input=b;	
	}
	int  gain(){
		int effort=2*input;
		return  effort;
	}
}
class Apple extends Fruit{
	int money;
	Apple(String e,int g,int f){
		// FruitName=e;
		// input=g;
		super(e,g);
		money=f;
	}
	int gain(){
		int effort=(2*input)-money;
		return effort;
	}
}
class Banana extends Fruit{
	Banana(String e,int g){
	super(e,g);
	}
	int gain(){
		int effort=3*input;
		return  effort;
	}
	
}

