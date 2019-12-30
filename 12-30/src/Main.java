import java.util.ArrayList;
import java.util.List;

interface Condition {
    boolean judge(String s1,String s2);
}

class EqualsCondition implements Condition {
    @Override
    public boolean judge(String s1, String s2) {
        return s1.equals(s2);
    }
}
public class Main {
    public static List<String> find(List<String> origin,String s ,Condition condition) {
        List<String> ret = new ArrayList<>();
        for (String s1 : origin) {
            if (condition.judge(s,s1)) {
                ret.add(s1);
            }
        }
        return ret;
    }
    public static List<String> findEquals(List<String> origin, String s) {
        List<String> ret = new ArrayList<>();
        for (String s1 : origin) {
            if (s1.equals(s)) {
                ret.add(s1);
            }
        }
        return ret;
    }

    public static List<String> findLessThan(List<String> origin,String s) {
        List<String> ret = new ArrayList<>();
        for (String s1 : origin) {
            if (s1.compareTo(s) < 0) {
                ret.add(s1);
            }
        }
        return ret;
    }

    public static List<String> findEqualsIgnoreCase(List<String> origin,String s) {
        List<String> ret = new ArrayList<>();
        for (String s1 : origin) {
            if (s1.equalsIgnoreCase(s)) {
                ret.add(s1);
            }
        }
        return ret;
    }
    public static List<String> findEndsWith(List<String> origin,String s) {
        List<String> ret = new ArrayList<>();
        for (String s1 : origin) {
            if (s1.endsWith(s)) {
                ret.add(s1);
            }
        }
        return ret;
    }

    public static List<String> findContains(List<String> origin,String s) {
        List<String> ret = new ArrayList<>();
        for (String s1 : origin) {
            if (s1.contains(s)) {
                ret.add(s1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<String> origin = new ArrayList<>();
        origin.add("abc");
        origin.add("hello");
        origin.add("world");
        origin.add("java");
        origin.add("bit");
        origin.add("CAT");
        origin.add("cat");

        System.out.println(findEquals(origin,"hello"));
        System.out.println(findEqualsIgnoreCase(origin,"cat"));
    }
}
