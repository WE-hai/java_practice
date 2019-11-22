import java.io.*;

public class Copy {

	public static void main(String[] args) {
		/*
		try {
			FileReader input = new FileReader("a.txt");
			FileWriter output = new FileWriter("b.txt");
			int c = input.read();
			while(c !=-1) {
				output.write(c);
				
				c = input.read();
			}
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		FileReader input;
		try {
			input = new FileReader("a.txt");
			BufferedReader br = new BufferedReader(input);
			FileWriter output = new FileWriter("d:\\c.txt");
			BufferedWriter wr = new BufferedWriter(output);
			String s = br.readLine();
			while(s != null) {
				wr.write(s);
				wr.newLine();
				s = br.readLine();
			}
			br.close();
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
