package 火车进站;

/*
 * 本题思路是：以每个火车为个体  都只有进站 出站两种操作。
 以此为基础进行递归，具体代码如下，有详细的注释，希望可以帮到大家~
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class TestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            //录入进站序列
            for (int i=0; i<n; i++) {
                array[i] = sc.nextInt();
            }
            //创建火车对象
            Train2 t = new Train2(array);
            //开始
            t.start();
        }
    }
}
class Train2{
    private ArrayList<String> results = new  ArrayList<String>();//储存结果
    private int[] array;//进站序列

    public Train2(int[] array) {
        this.array = array;
    }

    public void start() {
        StringBuilder outStation = new StringBuilder(); //出站的序列
        Stack<Integer> inStation = new Stack<Integer>();//站内情况的序列
        int index = 0;// 记录进站的次数
        //调用递归
        trainOut(outStation, inStation, index);
        //按字典序排序
        Collections.sort(results);
        //打印结果
        printResults();
    }

    //打印结果
    private void printResults() {
        for (String s : results) {
            for (int i=0; i<s.length(); i++) {
                if(i!=s.length()-1) {
                    System.out.print(s.charAt(i)+" ");
                } else {
                    System.out.println(s.charAt(i));
                }
            }
        }

    }

    /*
     * 只有两种操作：火车进站   火车出战
     */
    private void trainOut(StringBuilder outStation, Stack<Integer> inStation, int index) {
        //递归出口：列车已经全部进过站
        if (index==array.length) {
            //如果站内还有火车  全部弹出站 并记录在出站序列中
            while (!inStation.isEmpty()) {
                outStation.append(inStation.pop());
            }
            //将出站序列固化为String 保存进results
            results.add(outStation.toString());
            return;
        }
        //如果站内还有火车 可以出站
        if (!inStation.isEmpty()) {
            //创建新的inStation和outStation
            Stack<Integer> newInStation = new Stack<Integer>();
            newInStation.addAll(inStation);
            StringBuilder newOutStation = new StringBuilder(outStation);
            newOutStation.append(newInStation.pop());
            //递归调用
            trainOut(newOutStation, newInStation, index);
        }
        //如果火车没有都进过栈 火车进站
        if (index<array.length) {
            Stack<Integer> newInStation = new Stack<Integer>();
            newInStation.addAll(inStation);
            newInStation.push(array[index]);
            trainOut(outStation, newInStation, index+1);
        }
    }
}