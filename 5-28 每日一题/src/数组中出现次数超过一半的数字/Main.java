import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static void checkContain(String A,String B){
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<A.length();i++){
            map.put(A.charAt(i),map.getOrDefault(A.charAt(i),0)+1);
        }

        for(int i=0;i<B.length();i++){
            if(map.containsKey(B.charAt(i))){
                int n=map.get(B.charAt(i));
                if(n==0){
                    System.out.println("No");
                    return;
                }
                map.put(B.charAt(i),map.get(B.charAt(i))-1);
            }else{
                System.out.println("No");
				return;
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            String[] str=s.split(" ");
            String A=str[0];
            String B=str[1];

            checkContain(A,B);
        }
    }
}