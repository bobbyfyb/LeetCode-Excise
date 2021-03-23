package algoritm.codinginterview;
/*
* 剑指offer 27. 二叉树的镜像
* https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        return root;

    }
}
