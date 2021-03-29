package algoritm.codinginterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
* 剑指Offer 32. 树的层序遍历
* https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/comments/
 */
public class TreeBFS {
    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> array = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            array.add(node.val);
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
        int[] res = new int[array.size()];
        for(int i = 0; i<res.length; ++i){
            res[i] = array.get(i);
        }
        return res;

    }
}
