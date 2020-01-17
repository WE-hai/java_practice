import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //插入
        list.add(10);
        list.add(0, 1);
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        //全部内容拷贝： 构造函数ArrayList(Collection<? extends E> c)
        List<Integer> list3 = new ArrayList<>(list);

        int index = list.indexOf(10);
        System.out.println(list.contains(1));
        System.out.println(list.contains(100));

        list.set(0, -1);
        System.out.println(list.get(0));

        List<Integer> subList = list.subList(0, 2); // [0, 2)
        System.out.println("subList:");
        for(int e : subList)
        {
            System.out.println(e);
        }

        for(int e : list)
        {
            System.out.println(e);
        }

        for(Integer e : list)
        {
            System.out.println(e);
        }

        Integer iobj = 1;
        list.remove(iobj);
        list.remove(0);
        for(int e : list)
        {
            System.out.println(e);
        }
        /*
        for(int e : subList)
        {
            System.out.println(e);
        }
         */
        List<String> strList = new ArrayList<>(10);
        //System.out.println(strList.get(0));
        System.out.println(strList.size());  // 0
    }
}
