package 二维数组的查找;

public class Solution {
    public boolean Find(int target, int [][] array) {
        for(int i = 0;i < array.length;i++) {
            for(int j = 0;j < array[0].length;j++) {
                if(array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
