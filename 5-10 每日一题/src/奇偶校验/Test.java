package 奇偶校验;

import java.util.*;
import java.math.*;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            BigInteger[] bg = new BigInteger[n];
            for(int i=0; i<n; i++)
                bg[i] = s.nextBigInteger();
            Arrays.sort(bg);
            for(int i=0; i<n; i++)
                System.out.println(bg[i]);
        }
    }
}
