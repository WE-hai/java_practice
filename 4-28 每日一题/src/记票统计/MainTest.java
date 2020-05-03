package 记票统计;

import java.util.*;

public class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            Map<String,Integer> map = new HashMap<>();
            int n=sc.nextInt();//表示候选人数
            for(int i=0;i<n;i++){
                //map里key为候选人名字，value为候选人持有的票数
                map.put(sc.next(),0);//将候选人放进Map里，初始时他们各自持有的票数为0
            }
            int voteNumber =sc.nextInt();//表示投票的人数
            int invalid=0;//表示无效的投票数
            for(int j=0;j<voteNumber;j++){
                String vote=sc.next();
                //如果map里不存在这个投票的人名，则无效投票数+1
                if(map.get(vote)==null){
                    invalid++;
                }else {
                    //如果map里存在这个投票的人名，则将这个人对应的票数+1
                    map.put(vote,map.get(vote)+1);
                }
            }
            //遍历Map，按题上要求的格式输出
            for(Map.Entry entry : map.entrySet()){
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            System.out.println("Invalid : "+invalid);
        }
    }
}