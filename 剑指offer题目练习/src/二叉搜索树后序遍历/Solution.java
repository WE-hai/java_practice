package 二叉搜索树后序遍历;

public class Solution {

    public boolean helpVerify(int [] sequence, int start, int root){
        if(start >= root) {
            return true;
        }
        int key = sequence[root];
        int i;
        //找到左右子数的分界点
        for(i = start; i < root; i++)
            if(sequence[i] > key)
                break;
        //在右子树中判断是否含有小于root的值，如果有返回false
        for(int j = i; j < root; j++)
            if(sequence[j] < key)
                return false;
        return helpVerify(sequence, start, i-1) && helpVerify(sequence, i, root-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        return  helpVerify(sequence, 0, sequence.length-1);
    }
}
