package 超长正整数相加;

import java.math.BigInteger;
import java.util.Scanner;

public class Test {
    public static String AddLongInteger(String addend,String augend){
        BigInteger a = new BigInteger("0");
        BigInteger bigInteger = new BigInteger(addend);
        BigInteger bigInteger1 = new BigInteger(augend);
        if(bigInteger.compareTo(a) > 0 && bigInteger1.compareTo(a) > 0) {
            bigInteger = bigInteger.add(bigInteger1);
            String str = String.valueOf(bigInteger);
            return str;
        }
        return null;
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String addend = scanner.nextLine();
            String augend = scanner.nextLine();
            System.out.println(AddLongInteger(addend, augend));
        }
    }
}