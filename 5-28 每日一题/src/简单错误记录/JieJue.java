package 简单错误记录;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

class ByValueComparator implements Comparator<String>{
    HashMap<String, Integer> base_map;
    public ByValueComparator(HashMap<String,Integer> map) {
        // TODO Auto-generated constructor stub
        this.base_map = map;
    }
    @Override
    public int compare(String str1, String str2) {
        // TODO Auto-generated method stub
        if(!base_map.containsKey(str1) || !base_map.containsKey(str2)){
            return 0;
        }
        if(base_map.get(str1) < base_map.get(str2)){
            return 1;

        }else if(base_map.get(str1) > base_map.get(str2)){
            //从大到小排序，因此若str1<str2，则返回1，即str2会排在str1前面；str1>str2,返回-1，则str1排在str2前面
            //从小到大排序，-1代表str1<str2；0代表==，不动位置；1代表str1>str2，str1放在str2后。
            return -1;
        }else{
            return 0;
        }
    }
}
public class JieJue {
    public static void main(String[] ags){
        LinkedHashMap<String, Integer> recMap = new LinkedHashMap<String, Integer>();
        Scanner input = new Scanner(System.in);
        String file = "";
        int errorLine = 0;
        int lastIndex = 0;
        String recName = "";
        while(input.hasNext()){
            file = input.next();
            errorLine = input.nextInt();
            lastIndex = file.lastIndexOf("\\");
            recName = (lastIndex < 0)?file:file.substring(lastIndex+1)+" "+errorLine;
            int count = 0;
            if(!recMap.containsKey(recName)){
                recMap.put(recName, 1);
            }else{
                count = recMap.get(recName);
                recMap.put(recName, count+1);
            }
        }
        input.close();
        //--------以上统计，以下排序取值-------------
        ArrayList<String> keys = new ArrayList<String>(recMap.keySet());
        System.out.println(keys.toString());
        ByValueComparator bvc = new ByValueComparator(recMap);
        Collections.sort(keys, bvc);
        System.out.println(keys.toString());
        for(int i = 0;i < (keys.size() > 8?8:keys.size());i++){
            String key = keys.get(i);
            StringBuilder res = new StringBuilder();
            lastIndex = key.lastIndexOf(" ");
            int value = recMap.get(key);
            if(lastIndex > 16){
                res.append(key.substring(lastIndex-16));
            }else{
                res.append(key);
            }
            res.append(" ").append(value);
            System.out.println(res.toString());
        }
    }
}
