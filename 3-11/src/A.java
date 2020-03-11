public class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }

    public static void main(String[] args) {
        A<Integer> a = new A<>(1);
        System.out.println(a.get());
    }
}
