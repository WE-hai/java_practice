package 字串判断;

public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] arr = new boolean[n];
        for (int i = 0;i < n;i++) {
            arr[i] = s.contains(p[i]);
        }
        return arr;
    }
}
