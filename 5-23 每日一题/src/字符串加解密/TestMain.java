package 字符串加解密;

import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s1 = in.next();
            String s2 = in.next();
            System.out.println(encrypt(s1));
            System.out.println(unencrypt(s2));
        }
        in.close();
    }

    public static String encrypt(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='a' && c<='y'){
                sb.append((char)(c-31));
            }else if(c=='z'){
                sb.append('A');
            }else if(c>='A' && c<='Y'){
                sb.append((char)(c+33));
            }else if(c=='Z'){
                sb.append('a');
            }else if(c>='0' && c<='8'){
                sb.append((char)(c+1));
            }else if(c=='9'){
                sb.append('0');
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String unencrypt(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='b' && c<='z'){
                sb.append((char)(c-33));
            }else if(c=='a'){
                sb.append('Z');
            }else if(c>='B' && c<='Z'){
                sb.append((char)(c+31));
            }else if(c=='A'){
                sb.append('z');
            }else if(c>='1' && c<='9'){
                sb.append((char)(c-1));
            }else if(c=='0'){
                sb.append('9');
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
