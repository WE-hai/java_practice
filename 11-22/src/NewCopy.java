import java.io.*;

public class NewCopy {
    public static void main(String[] args) {
        FileReader input;
        try {
            input = new FileReader("a.txt");
            BufferedReader br = new BufferedReader(input);
            FileWriter output = new FileWriter("d:\\c.txt");
            BufferedWriter wr = new BufferedWriter(output);
            String s = br.readLine();
            while (s != null) {
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
