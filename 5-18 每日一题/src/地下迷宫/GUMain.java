import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
    static int m,n;
    static List<int[]>list;
    static List<int[]>bestPath;
    static int bestP = -1;
    static  int[]dx = {0,1,-1,0};//右下上左
    static  int[]dy = {1,0,0,-1};
    static  int[]ps = {1,0,3,1};
    //地下迷宫
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        list=new ArrayList<>();
        while (scan.hasNextInt()){
            m=scan.nextInt();
            n=scan.nextInt();
            int p=scan.nextInt();
            int[][]map=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    map[i][j]=scan.nextInt();
                }
            }
            findPath(0,0,p,map);
            if (bestPath==null){
                System.out.println("Can not escape!");
            }else{
                StringBuilder sb=new StringBuilder();
                for (int i=0;i<bestPath.size();i++){
                    int[]arr=bestPath.get(i);
                    int x=arr[0],y=arr[1];
                    sb.append("[" + x + "," + y + "]");
                    if (i<bestPath.size()-1){
                        sb.append(",");
                    }
                }
                System.out.println(sb.toString());
            }
        }

    }


    private static void findPath(int i, int j, int p,int[][]map) {
        list.add(new int[]{i,j});
        if (i==0&&j==n-1&&p>=0){
            if (p>bestP){
                bestP=p;
                bestPath=new ArrayList<>(list);
            }
            return;
        }
        map[i][j]=0;
        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0&&x<m&&y>=0&&y<n&&map[x][y]==1&&p-ps[k]>=0){
                findPath(x,y,p-ps[k],map);
            }
        }
        map[i][j]=1;
        list.remove(list.size()-1);
    }

}
