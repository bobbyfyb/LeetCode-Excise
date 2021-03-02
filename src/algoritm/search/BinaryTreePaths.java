package algoritm.search;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String>  binaryTreePaths(TreeNode root){
        List<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(root,path, ans);
        return ans;
    }
    private void dfs(TreeNode root, StringBuilder path, List<String> ans){
        if(root == null)
            return;
        if(root.right==null && root.left==null){
            ans.add(path.toString() + root.val);
            return;
        }
        int len = path.length();
        path.append(root.val).append("->");
        dfs(root.left, path, ans);
        dfs(root.right, path, ans);
        path.delete(len, path.length());
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}