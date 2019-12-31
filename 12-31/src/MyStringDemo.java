import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStringDemo {
    private final char[] value;
    private final int length;
    //不是真正的常量池，只是利用静态属性模拟常量池
    private static List<MyStringDemo> constantPool = new ArrayList<>();

    public MyStringDemo(char[] value) {
        this.value = Arrays.copyOf(value,value.length);
        this.length = value.length;
    }

    public MyStringDemo concat(MyStringDemo s) {
        char[] v = new char[length+s.length];
        System.arraycopy(value,0,v,0,length);
        System.arraycopy(s.value,0,v,length,s.length);
        return new MyStringDemo(v);
    }

    public char[] toCharArray() {
        return Arrays.copyOf(value,length);
    }
    //判断池中有无相同的对象
    public MyStringDemo intern() {
        for(MyStringDemo s : constantPool) {
            if (s.equals(this)) {
                return s;
            }
        }
        constantPool.add(this);
        return this;  //this指向当前对象
    }
}
