import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(3,40);
        System.out.println("list:"+list);

        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        System.out.println("list1:"+list1);
        int index = list.indexOf(10);
        System.out.println(index);
        System.out.println(list.contains(10));
        System.out.println(list.contains(100));
        System.out.println(list.get(1));
        list.set(1,100);
        System.out.println(list);

        List<Integer> sublist = list.subList(0,2);
        for (Integer e : sublist) {
            System.out.println(e);
        }
        for (Integer e : list) {
            System.out.println(e);
        }
        Integer i = 1;
        list.remove(i);
        list.remove(0);
        System.out.println(list);
        for (int e : list) {
            System.out.println(e);
        }

        List<String> str = new ArrayList<>(10);
        //System.out.println(str.get(0));
        System.out.println(str.size());
    }
}
