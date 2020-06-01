package 电话号码;

import java.util.*;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            ArrayList<String> arrayList=new ArrayList<>();
            int n=scanner.nextInt();
            String [] str=new String[n];
            for (int i = 0; i <str.length ; i++) {
                str[i]=scanner.next();
                String ret=toCoverse(str[i]).toString();
                ret=ret.substring(0,3)+"-"+ret.substring(3,7);
                if(!arrayList.contains(ret)){
                    arrayList.add(ret);
                }
            }
            Collections.sort(arrayList);
            for (int i = 0; i <arrayList.size() ; i++) {
                System.out.println(arrayList.get(i));
            }
            System.out.println();
        }
    }
    public  static StringBuilder toCoverse(String s) {
        StringBuilder list=new StringBuilder();
        char []ch=s.toCharArray();
        for (int i = 0; i <ch.length ; i++) {
            if(ch[i]>='0'&&ch[i]<='9'){
                list.append(ch[i]);
            }
            if(ch[i]>='A'&&ch[i]<='C'){
                list.append('2');
            }
            if(ch[i]>='D'&&ch[i]<='F'){
                list.append('3');
            }
            if(ch[i]>='G'&&ch[i]<='I'){
                list.append('4');
            }
            if(ch[i]>='J'&&ch[i]<='L'){
                list.append('5');
            }
            if(ch[i]>='M'&&ch[i]<='O'){
                list.append('6');
            }
            if(ch[i]>='P'&&ch[i]<='S'){
                list.append('7');
            }
            if(ch[i]>='T'&&ch[i]<='V'){
                list.append('8');
            }
            if(ch[i]>='W'&&ch[i]<='Z'){
                list.append('9');
            }
        }
        return list;
    }
}