package 路径总数;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int uniquePaths(int m,int n) {
        List<List<Integer>> pathNum = new ArrayList<>();
        //申请F(i,j)空间，初始化
        for (int i = 0;i < m;i++) {
            pathNum.add(new ArrayList<>());
            pathNum.get(i).add(1);
        }
        for (int i = 1;i < n;i++) {
            pathNum.get(0).add(1);
        }
        for (int i = 1;i < m;i++) {
            for (int j = 1;j < n;j++) {
                // F(i,j) = F(i-1,j) + F(i,j-1)
                pathNum.get(i).add(pathNum.get(i).get(j-1)+ pathNum.get(i-1).get(j)) ;
            }
        }
        return pathNum.get(m-1).get(n-1);
    }
}
