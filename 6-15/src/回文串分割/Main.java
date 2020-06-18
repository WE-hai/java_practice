package 回文串分割;

public class Main {
    //判断是否回文串
    public boolean isPal(String s,int start,int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int minCut(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] arr = new int[s.length()+1];
        for (int i = 0;i <= s.length();i++) {
            arr[i] = i-1;
        }
        for (int i = 1;i <= s.length();i++) {
            for (int j = 0;j < i;j++) {
                if (isPal(s,j,i-1)) {
                    arr[i] = Math.min(arr[i],arr[j]+1);
                }
            }
        }
        return arr[s.length()];
    }
}
