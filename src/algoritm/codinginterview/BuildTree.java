package algoritm.codinginterview;
/*
* 剑指offer 07. 重建二叉树
* https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildTree {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder){
        int n = preorder.length;
        indexMap = new HashMap<>();
        for(int i=0; i<n; ++i)
            indexMap.put(inorder[i], i);
        return building(preorder, inorder, 0, n-1, 0, n-1);
    }

    private TreeNode building(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left>preorder_right)
            return null;

        int preorder_root = preorder_left;
        int inorder_root = indexMap.get(preorder[preorder_root]);
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int size_left_subtree = inorder_root-inorder_left;
        root.left = building(preorder, inorder, preorder_left+1, preorder_left+size_left_subtree, inorder_left, inorder_root-1);
        root.right = building(preorder, inorder, preorder_left+size_left_subtree+1, preorder_right, inorder_root+1, inorder_right);
        return root;
    }

}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
