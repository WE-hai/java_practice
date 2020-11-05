package 字符串的排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class Main {
    public ArrayList<String> Permutation(String str) {
        StringBuilder buffer = new StringBuilder(str); //使用StringBuilder

        ArrayList<String> list1 = PermutationHelp(buffer);

        HashSet<String> set = new HashSet<>(list1);//构造包含list所有元素的HashSet
        ArrayList<String> list2 = new ArrayList<String>(set);//再装到数组中
        Collections.sort(list2);//进行字典序排序
        return list2;
    }

    public ArrayList<String> PermutationHelp(StringBuilder str){
        ArrayList<String> result = new ArrayList<>();//用来装所有结果的数组
        if (str.length() == 1) {//递归终止条件
            result.add(str.toString());
        } else {
            for (int i = 0;i < str.length();i++){
                //下面三句是将字符串进行交换
                char temp = str.charAt(i);
                str.setCharAt(i,str.charAt(0));
                str.setCharAt(0,temp);
                //交换后，除去刚刚交换的字符串，剩余的字符串继续调用递归
                StringBuilder buf = new StringBuilder(str.substring(1));
                ArrayList<String> arrayList = PermutationHelp(buf);
                //到这里说明某一次交换的递归完成，此时需要将结果添加
                for (int j = 0;j < arrayList.size();j++) {
                    //添加字符串[start,end）中的字符串
                    result.add(str.substring(0,1)+arrayList.get(j));
                }
                //temp=str.charAt(0);
                //str.setCharAt(0,str.charAt(i));
                //str.setCharAt(i,temp);
                //上面三句是将换出的字符再换回去，但实际可以省略
                //不换回去，从整体上来看，顺序乱了，但是遍历时依旧会遍历所有情况，在纸上画一画很清楚。
                //这3句可以省略，因为最终使用了Collections的排序方法，使得即使不换回去，排序过后依旧字典序
                //添加这三句代码，就有点回溯的味道了。
            }
        }
        return result;
    }
}
//result.add(str.substring(0,1)+arrayList.get(j));不容易理解，如abc定住a后，子问题是bc
//递归的返回值，定b后，返回c，则str取b，arrayList取c，合并成bc添加到result，
//递归的返回值，定c后，返回b，则str取c，arrayList取b，合并成cb添加到result，
//arrayList是拿到的就是result
//再向上返回时，str变成a，则arrayList是bc和cb的集合，所以需要一个for循环。拼接成abc和acb

