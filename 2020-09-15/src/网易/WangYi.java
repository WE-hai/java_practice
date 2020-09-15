package 网易;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WangYi {
    static List <List<String>> ret;
    static List<String> path;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            int n  =  Integer.valueOf(scan.nextLine());
            String[] strings  =  new String[n];
            for(int i = 0;i < n;i++) {
                strings[i] = scan.nextLine();
            }
            String[][] strs = new String[n][];
            for(int i = 0;i < n;i++) {
                strs[i] = strings[i].split(" ");
            }
            int num = 1;
            for(int i = 0;i < n;i++) {
                num *= strs[i].length;
            }
            ret = new ArrayList<>();
            path = new ArrayList<>();
            dfs(strs,0,n);
            for(int k = 0;k < num/strs[0].length;k++){
                for(int i = k;i < ret.size();i += num/strs[0].length){
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0;j < ret.get(i).size();j++){
                        sb.append(ret.get(i).get(j));
                        if(j < ret.get(i).size()-1){
                            sb.append('-');
                        }
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }

    private static void dfs(String[][] strs, int rol,int cnt) {
        if(path.size() == cnt){
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i < strs[rol].length;i++){
            path.add(strs[rol][i]);
            dfs(strs,rol+1,cnt);
            path.remove(path.size()-1);
        }
    }
}
