import java.util.Stack;

public class Main {
    public boolean isValid(String s) {
        final char[][] arr = {{'(',')'},{'[',']'},{'{','}'}};
        Stack<Character> st = new Stack<>();
        for(int i = 0;i < s.length();i++) {
            char cur;
            int flag = 0;
            for(int j = 0;j < arr.length;j++) {

            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        Main main = new Main();
        String s = "([]{}[{{[()}})";
        System.out.println(main.isValid(s));
    }
}
