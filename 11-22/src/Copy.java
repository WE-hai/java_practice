import java.io.*;

public class Copy {
    public static void main(String[] args) {
        try {
            FileReader input = new FileReader("a.txt");
            FileWriter output = new FileWriter("b.txt");
            int c = input.read();
            while (c != -1) {
                output.write(c);
                c = input.read();
            }
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
