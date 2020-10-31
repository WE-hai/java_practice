package 二叉搜索树后序遍历;

public class Main {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return  verify(sequence,0,sequence.length-1);
    }

    public boolean verify(int[] seq,int left,int right){
        //极端条件处理
        if(seq==null || seq.length==0) {
            return false;
        }

        //===================递归的退出条件===================
        if(left>=right) {
            return true;
        }

        //===================递归的处理方法体=====================
        int root = seq[right];  //根永远都是子树的最右边的那个节点
        int i = left;  //用于元素比较的指针
        int split = 0; //标记大小分界点，用于递归传参

        //处理判断左子树，从头开始找，如果当前值小于root,指针右移
        while(i<right && seq[i]<root){
            i++;
        }

        //标记切割点（此时指针i指向了右子树的第一个大于root的节点）
        split = i;

        //判断右子树
        if(i>=right){
            //说明在上边的查找左子树的中已经走到头了，该次没有右子树，且左子树都小于root
            return true; //仅有左子树无右子树也无序递归了，直接返回这组数据满足
        }else{
            //如果还没到头，那就继续比较看是否都是大于root的节点
            while(i<right){
                if(seq[i]>root) {
                    i++;
                } else {
                    return false;
                }  //存在不满足的情况直接返回了false；
            }
        }
        //递归子树（正常退出了上述的while,那么就是此次满足，递归遍历该次分割的子树，两子树都满足则满足）
        return verify(seq,left,split-1) && verify(seq,split,right-1);
    }
}
