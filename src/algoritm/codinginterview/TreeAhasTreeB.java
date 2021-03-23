package algoritm.codinginterview;
/*
* 剑指offer 26. 树的子结构
* https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class TreeAhasTreeB {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean res = false;
        if(A!=null && B!=null){
            if(A.val == B.val)
                res = isAhaveB(A, B);
            if(!res)
                res = isSubStructure(A.left, B);
            if(!res)
                res = isSubStructure(A.right, B);
        }
        return res;
    }

    private boolean isAhaveB(TreeNode A, TreeNode B){
        if(B == null)
            return true;
        if(A == null)
            return false;
        if(A.val!=B.val)
            return false;
        return isAhaveB(A.left, B.left) && isAhaveB(A.right, B.right);
    }

}
