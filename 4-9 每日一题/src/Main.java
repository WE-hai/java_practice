public class Main {
    //default String s;
    public final static native int w();
    //abstract double b;
    public static void main(String[] args) {

        Object o = new Object() {
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }
}
