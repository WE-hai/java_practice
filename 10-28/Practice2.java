public class Practice2{
	public static void main(String[] args){
	int a = 4;
	int b = 8;
	int c = 3;
	int tmp = 0;
	int max = 0;
	int min = 0;
	if(a<b){
		tmp = a;
		a = b;
		b = tmp;
	}
	if(a<c){
		tmp = a;
		a = c;
		c = tmp;
	}
	if(b<c){
		tmp = b;
		b = c;
		c = tmp;
		min = c;
	}
	max = a;
	min = c;
	System.out.println("max="+max);
	System.out.println("min="+min);
	}
}