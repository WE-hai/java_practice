package 坐标移动;


import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(";");
        int x = 0,y=0;
        for(int i=0;i<tokens.length;i++){
            try{
                int b = Integer.valueOf(tokens[i].substring(1,tokens[i].length()));
                switch (tokens[i].charAt(0)){
                    case 'A':
                        x -=b;
                        break;
                    case 'W':
                        y +=b;
                        break;
                    case 'S':
                        y -=b;
                        break;
                    case 'D':
                        x +=b;
                        break;
                }
            }catch (Exception e){
                System.out.println("非法不处理和空格不处理");
                continue;
            }


            System.out.println("横坐标x="+x+","+"纵坐标y="+y);
        }
    }
}