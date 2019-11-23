import java.io.*;

public class TestPut {
    public static void main(String[] args) {

        int n = 0;
        try {
            n = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println((char) n);
    }
}
