class Fruit {
	String fruitName;
	int input;
	Fruit() {
		System.out.println(fruitName);
		System.out.println(input);
	}
	Fruit(String fruitName,int input){
		this.fruitName = fruitName;
		this.input = input;
		System.out.println(fruitName);
		System.out.println("投入是："+input);
	}
	int gain() {
		return 2*input;
	}
	public static void main(String[] args) {
		Apple a = new Apple("apple",200);
		Banana b = new Banana("banana",300);
		int output1 = a.gain(200);
		int output2 = b.gain(300);		
		System.out.println("苹果的收益："+output1);
		System.out.println("香蕉的收益："+output2);
		Fruit f[] = new Fruit[2];
		Fruit c = new Fruit("apple",200);
		Fruit d = new Fruit("banana",300);
		f[0] = c;
		f[1] = d;
		for(int i = 0;i < f.length;i++) {
			System.out.println(f[i].fruitName+"的收益是："+f[i].gain());
		}
	}

}
class Apple extends Fruit {
	
	Apple() {
		System.out.println(fruitName);
		System.out.println(input);
	}
	Apple(String fruitName,int input) {
		super(fruitName,input);
		
	}
	int gain(int input) {
		return 2*input-200;
		}
}
class Banana extends Fruit {
	
	Banana() {
		System.out.println(fruitName);
		System.out.println(input);
	}
	Banana(String fruitName,int input) {
		super(fruitName,input);
		
	}
	int gain(int input) {
		return 3*input;
	}

}
