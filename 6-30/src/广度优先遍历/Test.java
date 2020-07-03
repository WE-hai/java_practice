package 广度优先遍历;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {
    //queue实现
    public static boolean bfs(int[][] graph,int startx,int starty,int destx,int desty) {
        //迷宫大小
        int m = graph.length;
        int n = graph[0].length;

        //储存迷宫的位置
        Queue<Node> q = new LinkedList<>();
        //标记迷宫中的位置是否被走过
        int[][] book = new int[m][n];
        q.offer(new Node(startx,starty));
        //标记已经走过
        book[startx][starty] = 1;

        //四个行走方向上下左右
        int[][] next = {{-1,0},{1,0},{0,-1},{0,1}};

        //标记是否可以出去
        boolean flag = false;

        while (!q.isEmpty()) {
            //当前位置带出所有新位置，可以上下左右
            for (int i = 0;i < 4;i++) {
                //计算新位置
                int nx = q.peek().x+next[i][0];
                int ny = q.peek().y+next[i][1];

                //新位置越界。继续下一个
                if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                    continue;
                }

                //如果新位置无障碍并且之前也没有走过，保存新位置
                if (graph[nx][ny] == 0 && book[nx][ny] == 0) {
                    q.offer(new Node(nx,ny));
                    //标记已被走过
                    book[nx][ny] = 1;
                }

                //如果新位置为目标位置，则结束查找
                if (nx == destx && ny == desty) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            //否则，用新位置继续向后走
            q.poll();
        }
        return flag;
    }

    public static void main(String[] args) {
        int sx,sy,ex,ey;
        int m,n;
        System.out.println("请输入迷宫大小：行，列");
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();

        int[][] graph = new int[m][n];
        System.out.println("请输入迷宫元素：");
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        while (true) {
            System.out.println("请输入迷宫入口和出口：");
            sx = scanner.nextInt();
            sy = scanner.nextInt();
            ex = scanner.nextInt();
            ey = scanner.nextInt();

            System.out.println("是否可以走出迷宫：");
            bfs(graph,sx,sy,ex,ey);
            System.out.println();
        }
    }
}
