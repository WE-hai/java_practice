import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pintu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int n = in.nextInt();
        for(int i=0; i<n; i++){
            int I = in.nextInt();
            int L = in.nextInt();
            if(I == 1){  //添加
                int j=0;
                for(;j<list.size(); j++){
                    if(list.get(j) >= L){
                        list.add(j,L);
                        break;
                    }
                }
                if(list.size() == j){
                    list.add(L);
                }
                sum += L;
            }else{
                list.remove(list.indexOf(L));
                sum -= L;
            }
            int max = list.get(list.size()-1);
            if(sum - max > max){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}