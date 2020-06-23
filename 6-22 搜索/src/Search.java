import java.util.Scanner;

public class Search {
    public static void dfs(int index,int n,int[] boxs,int[] book) {
        if (index == n+1) {
            for (int i = 1;i <= n;i++) {
                System.out.print(boxs[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1;i <= n;i++) {
            if (book[i] == 0) {
                boxs[index] = i;
                book[i] = 1;
                dfs(index+1,n,boxs,book);
                book[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] boxs = new int[n+1];
        int[] book = new int[n+1];
        dfs(1,n,boxs,book);

    }
}
