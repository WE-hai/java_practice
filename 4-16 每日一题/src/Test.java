public class Test {
    public static void main(String[] args) {
        int i = 5;
        int s = (i++)+(++i)+(i--)+(--i);
        System.out.println(s);
    }
}
