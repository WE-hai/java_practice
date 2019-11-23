import java.io.*;

public class Put {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        FileWriter output;
        try {
            String a = input.readLine();
            output = new FileWriter("a.txt");
            output.write(a);
            System.out.println("成功");
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
