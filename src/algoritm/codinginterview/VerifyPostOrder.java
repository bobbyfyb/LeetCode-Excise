package algoritm.codinginterview;
/*
* 剑指offer 33. 二叉树的后序遍历序列
* https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/comments/
 */
public class VerifyPostOrder {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length == 0)
            return true;
        int root = postorder[postorder.length - 1];
        int left = 0;
        while(postorder[left]<root){
            ++left;
        }
        int right = left;
        while(right<postorder.length-1){
            if(postorder[right] < root)
                return false;
            right++;
        }
        int[] leftSubTree = new int[left];
        int[] rightSubTree = new int[postorder.length - left - 1];
        for(int i = 0; i<leftSubTree.length; ++i){
            leftSubTree[i] = postorder[i];
        }
        for(int i = 0; i<rightSubTree.length; ++i){
            rightSubTree[i] = postorder[i+left];
        }


        return verifyPostorder(leftSubTree) && verifyPostorder(rightSubTree);
    }
}
