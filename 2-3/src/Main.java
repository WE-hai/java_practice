public class Main {
    //precondition: x >=0
    public void mystery(int x) {
        System.out.print(x % 10);
        if ((x / 10) != 0){
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }
    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }

    public static void main(String[] args) {
        Cat.sleep();
        Main a = new Main();
        a.mystery(1234);
        System.out.println();
        System.out.println(getValue(2));
    }
}
