package 在霍格沃茨找零钱;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String p = scanner.nextLine();
            String a = scanner.nextLine();
            String[] arr1 = p.split(".");
            String[] arr2 = a.split(".");
            int pSum=Integer.valueOf(arr1[0])*17*29+Integer.valueOf(arr1[1])*29+Integer.valueOf(arr1[2]);
            int aSum=Integer.valueOf(arr2[0])*17*29+Integer.valueOf(arr2[1])*29+Integer.valueOf(arr2[2]);
            int flag = 1;
            int change = aSum-pSum;
            if (flag < 0) {
                change = -change;
                flag = -flag;
            }
            int p1 = change/(17*29);
            int p2 = (change-p1*17*29)/29;
            int p3 = (change-p1*17*29-p2*29);
            p1 *= flag;
            System.out.println(p1+"."+p2+"."+p3);
        }
    }
}
