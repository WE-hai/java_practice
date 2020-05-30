package 坐标移动;

import java.util.Scanner;

class Point{
    private int x;
    private int y;

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return x + "," + y;
    }
}


public class TestMain {

    /**
     * 利用空间存储指令的方向移量
     */
    private static final String INSTRUCT_LETTER = "ASWD";
    private static final int[]  distenceX = {-1, 0, 0, 1};
    private static final int[]  distenceY = {0, -1, 1, 0};

    private static int find(char ch){
        for(int i = 0; i < INSTRUCT_LETTER.length(); i++){
            if(ch == INSTRUCT_LETTER.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isNum(char ch){
        if(ch >= '0' && ch <= '9')  {
            return true;
        } else  {
            return false;
        }
    }

    public static void move(Point point, String instruct){
        if(instruct.equals("") || instruct.length() > 3 || find(instruct.charAt(0)) == -1)  { return ;}
        int x = 0;
        int y = 0;
        for(int i = 1; i < instruct.length(); i++){
            if(isNum(instruct.charAt(i))){
                // x,y上的移量为倍数乘以单位移量
                x = x * 10 + (instruct.charAt(i) - '0') * distenceX[find(instruct.charAt(0))];
                y = y * 10 + (instruct.charAt(i) - '0') * distenceY[find(instruct.charAt(0))];
            }
            else return;
        }
        point.setX(point.getX() + x);
        point.setY(point.getY() + y);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String str = input.nextLine();
            String[] instructs = str.split(";");
            Point origin = new Point();
            for(String instruct : instructs) {
                move(origin, instruct);
            }
            System.out.println(origin);
        }
    }
}