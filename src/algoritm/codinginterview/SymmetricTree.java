package algoritm.codinginterview;
/*
* 剑指Offer 28. 对称二叉树
* https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetrical(root, root);

    }

    private boolean isSymmetrical(TreeNode tree1, TreeNode tree2){
        if(tree1==null && tree2==null)
            return true;
        if(tree1==null || tree2 == null)
            return false;
        if(tree1.val != tree2.val)
            return false;
        return isSymmetrical(tree1.left, tree2.right) && isSymmetrical(tree1.right, tree2.left);
    }
}
