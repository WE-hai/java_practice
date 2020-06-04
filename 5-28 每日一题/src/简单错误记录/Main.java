package 简单错误记录;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> hashmap = new HashMap<>();
        List<String> arraylist = new ArrayList<>();

        while(sc.hasNext()) {
            String[] info = sc.nextLine().split("\\\\");
            String parseInfo = info[info.length - 1];
            if (arraylist.contains(parseInfo)) {
                hashmap.put(parseInfo,hashmap.get(parseInfo)+1);
            } else {
                arraylist.add(parseInfo);
                hashmap.put(parseInfo,1);
            }
        }
        int temp = 1;
        arraylist.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(hashmap.get(o1)<hashmap.get(o2)) {
                    return 1;
                }else if(hashmap.get(o1)>hashmap.get(o2)) {
                    return -1;
                } else {
                    if (arraylist.indexOf(o1)>arraylist.indexOf(o2)) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        sc.close();
        for (String s : arraylist ) {
            if(temp > 8) {
                break;
            }
            temp++;
            int length = s.split(" ")[0].length();
            int cut_l = length - 16;
            int olength = s.length() - cut_l;
            if(length<=16) {
                System.out.println(s+" "+hashmap.get(s));
            } else {
                System.out.println(s.substring(s.length()-olength,s.length())+" "+hashmap.get(s));
            }
        }
    }
}
