package algoritm.codinginterview;
/*
* 剑指offer 32-ＩＩ　分层打印二叉树
* https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBFSperRow {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int toBeAdded = 1, nextLevel = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            row.add(node.val);
            toBeAdded--;
            if(node.left != null){
                queue.offer(node.left);
                ++nextLevel;
            }
            if(node.right!=null){
                queue.offer(node.right);
                ++nextLevel;
            }
            if(toBeAdded == 0){
                res.add(row);
                row = new ArrayList<>();
                toBeAdded = nextLevel;
                nextLevel=0;
            }
        }
        return res;

    }
}
