package algoritm.search;
/*
* https://leetcode-cn.com/problems/permutations/
 */
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(nums, 0, ans);
        return ans;
    }
    private void backtracking(int[] nums, int level, List<List<Integer>> ans){
        if(level == nums.length - 1){
            List<Integer> a = new ArrayList<>();
            for (int num : nums) a.add(num);
            ans.add(a);
            return;
        }
        for(int i = level; i< nums.length;i++) {
            swap(nums, i, level);
            backtracking(nums, level + 1, ans);
            swap(nums, i, level);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        new Permutations().permute(new int[]{1, 2, 3});
    }
}
