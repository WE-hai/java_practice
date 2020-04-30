package 人民币转换;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Character,Character> map = new HashMap<>();
    private static void buidMap(){
        map.put('1','壹');
        map.put('2','贰');
        map.put('3','叁');
        map.put('4','肆');
        map.put('5','伍');
        map.put('6','陆');
        map.put('7','柒');
        map.put('8','捌');
        map.put('9','玖');
        map.put('0','零');
    }
    public static void main(String[] args) {
        buidMap();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String money = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            sb.append("人民币");
            int INT = 0;
            for(int i = 0;i < money.length();i++){
                if (money.charAt(i) == '.'){
                    break;
                }
                INT++;
            }
            int idx = 0;
            int count = INT;
            while (idx < INT){
                int max = (count%4 == 0 ? 4 : count%4);
                int copy = max;
                StringBuilder tmp = new StringBuilder();
                while (max > 0 && idx < INT){
                    tmp.append(money.charAt(idx));
                    idx++;
                    max--;
                }
                sb.append(change(tmp.toString()));
                if (count > 4 && count <= 8){
                    sb.append('万');
                }else if(count > 8 && count <= 12){
                    sb.append('亿');
                }
                count -= copy;
            }
            if (INT == 1 && money.charAt(0) == '0') {
                sb.append("");
            } else {
                sb.append("元");
            }
            sb.append(changePast(money.substring(INT+1)));
            System.out.println(sb.toString());

        }
    }
    private  static String changePast(String x){
        StringBuilder sb = new StringBuilder();
        if (x.equals("00")){
            return "整";
        }
        if (x.charAt(0) != '0'){
            sb.append(map.get(x.charAt(0)));
            sb.append("角");
        }
        if (x.charAt(1) != '0'){
            sb.append(map.get(x.charAt(1)));
            sb.append("分");
        }
        return sb.toString();
    }

    private static String unit(int n){
        if(n == 2){
            return "拾";
        }
        if(n == 3){
            return "佰";
        }
        if (n == 4){
            return "仟";
        }
        return "";
    }

    private static String change(String x){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < x.length()){

            while (idx < x.length() && x.charAt(idx) != '0'){
                if(x.charAt(idx) == '1' && idx == 0 && x.length() == 2){
                    sb.append("");
                } else {
                    sb.append(map.get(x.charAt(idx)));
                }
                sb.append(unit(x.length()-idx));
                idx++;
            }
            while (idx < x.length() && x.charAt(idx) == '0'){
                idx++;
            }
            if (idx < x.length()){
                sb.append("零");
            }
        }
        return sb.toString();
    }
}