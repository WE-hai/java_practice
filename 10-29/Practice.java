public class Practice {
	public static void main (String[] args) {
	int n = Integer.parseInt(args[0]);
	//int i = 1;
	int sum = 1;
	for(int i = 1;i <= n;i++){
		sum *= i;
	}
	System.out.println(""+n+"!="+sum);
	}
}