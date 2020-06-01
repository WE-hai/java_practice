package 求和;
/*思路：实质就是暴力解决问题，将所有的情况枚举出来，然后删选出符合自己要求的结果

   对于1,2,3....n的数中随便选出其中几个出来，只要和是m,就以字典序输出
   其实就是取决于我对于每个数的取舍问题：
     比如  对于数字 1 我只有两种策略：要或者不要
                                        要的我用res记录下来，并且加到sum中
                                        不要的我直接过（可参照下面代码）
           对于数字 2 我也只有两种策略：要或者不要
   依次类推..........

   最后的结束标志：就是我到最后一个数字 n 判定完成之后，看我的 sum 和 m 是否相等
                   相等就输出，然后结束这一个分支的递归
                   不相等就不输出，但是也要结束这个分支的递归

   按照先要再不要的策略，最后输出的结果就是字典序。
*/

import java.util.*;

public class TestMain{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String res = "";//用来记录被选到的数
        int sum = 0; //用来记录被选到数加起来的总和
        int []num = new int[n];
        int j =1;
        for(int i = 0;i < n;i++)
            num[i] = j++;
        process(num,m,res,sum,0);
    }

    public static void process(int[] num,int m,String res,int sum,int i){
        if(i == num.length){
            if(sum == m)
                //这里用trim（）方法就是去除每个输出最后的一个空格
                System.out.println(res.trim());
            return;
        }
        //表示我将num[i]这个数选到了
        process(num,m,res+num[i]+" ",sum+num[i],i+1);

        //表示我不要num[i]这个数
        process(num,m,res,sum,i+1);
    }
}
