class Base {
    public Base(String s) {
        System.out.print("B");
    }
}
public class Deived extends Base {
    public Deived(String s) {
        super(s);
        System.out.println("D");
    }

    public static void main(String[] args) {

    }
}