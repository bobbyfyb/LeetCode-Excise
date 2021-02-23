package algoritm.search;
/*
* https://leetcode-cn.com/problems/combinations/
 */
import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        for(int i = 0; i<k; i++){
            comb.add(0);
        }
        int count = 0;
        backtracking(ans, comb, count, 1, n, k);
        return ans;
    }
    private void backtracking(List<List<Integer>> ans, List<Integer> comb, int count, int pos, int n, int k){
        if(count == k){
            ans.add(new ArrayList<>(comb));
            return;
        }
        for(int i = pos; i<=n; ++i){
            comb.set(count++, i);
            backtracking(ans, comb, count, i+1, n, k);
            --count;
        }
    }

    public static void main(String[] args) {
        new Combinations().combine(4, 2);
    }
}
