package 题目2;

import java.util.Scanner;

public class Main {
    //搬家公司正在帮助一家人将小物体装箱。一个箱子的大小是有限的，
    // 公司可以把一个箱子分成最多k个独立的隔间，
    // 将一个箱子分成r个隔间需要r-1个隔板（这一个箱子没有放隔板也拥有一个本身的隔间）。
    // 而这一次搬家工作只携带了b个隔板。
    //在每一个隔间中，由于物件放多了容易损坏，最多只能放v个物体。
    // 现在这家人有a个物体，请问最少需要多少个箱子，才能将所有的物体装箱？
    public static int method(int a,int b,int k,int v) {
        int count = 0;
        if (a > 0) {
            count++;
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();
            int v = scanner.nextInt();
            System.out.println(method(a, b, k, v));
        }
    }
}
