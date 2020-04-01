import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(HuiWen(s));
        }
    }
    public static boolean HuiWen(String s) {
        int len = s.length();
        int sum=0;
        String res = new StringBuffer(s).reverse().toString();
        for (int i=0;i<s.length();i++)
            if (s.charAt(i)==res.charAt(i)) sum++;
        if (len-sum==0)
            return true;
        else return false;
    }
}
