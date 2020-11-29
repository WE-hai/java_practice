package 买苹果;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n <= 5){
            System.out.println(-1);
        }
        if(n%8 == 0){
            System.out.println(n/8);
        }else if((n%8)%2 == 0 && n != 10){
            System.out.println(n/8+1);
        }else{
            System.out.println(-1);
        }
    }
}