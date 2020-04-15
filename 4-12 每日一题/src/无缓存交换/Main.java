package 无缓存交换;

public class Main {
    public int[] exchangeAB(int[] AB) {
        // write code here
        AB[0] = AB[0]+AB[1];
        AB[1] = AB[0]-AB[1];
        AB[0] = AB[0]-AB[1];
        return AB;
    }
    public static void main(String[] args) {

    }
}
