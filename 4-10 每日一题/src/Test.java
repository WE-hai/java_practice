public class Test {
    public static int get(int v) {
        int ret = 0;
        switch (v) {
            case 1:
                ret = ret+v;
            case 2:
                ret = ret+2*v;
            case 3:
                ret = ret+3*v;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(get(2));
    }
}
