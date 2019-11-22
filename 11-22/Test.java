import java.io.*;

public class Test {

	public static void main(String[] args) {
		/*
		int n=0;
		try {
			n=System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println((char)n);
		*/
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		FileWriter output;
		try {
			String a = input.readLine();
			output = new FileWriter("a.txt");
			output.write(a);
			System.out.println("–¥»Î≥…π¶£°");
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
