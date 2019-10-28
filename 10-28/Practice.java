public class Practice {
	public static void main (String[] args) {
	int a = 3;
	int b = 7;
	int tmp = 0;
	System.out.println("a="+a);
	System.out.println("b="+b);
	tmp = a;
	a = b;
	b = tmp;
	System.out.println("a="+a);
	System.out.println("b="+b);
	}
}