package algoritm.search;
/*
* https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {
    private int[] direction = new int[]{-1, 0, 1, 0, -1};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        List<List<Boolean>> can_reach_p = new ArrayList<>();
        List<List<Boolean>> can_reach_a = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<m; i++){
            can_reach_a.add(i, new ArrayList<>());
            can_reach_p.add(i, new ArrayList<>());
            for (int j = 0; j<n; j++){
                can_reach_a.get(i).add(j, false);
                can_reach_p.get(i).add(j, false);
            }
        }

        for(int i = 0; i<m; ++i){
            dfs(matrix, can_reach_p, i, 0);
            dfs(matrix, can_reach_a, i, n-1);
        }
        for(int i = 0; i<n; ++i){
            dfs(matrix, can_reach_p, 0, i);
            dfs(matrix, can_reach_a, m-1, i);
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(can_reach_a.get(i).get(j) && can_reach_p.get(i).get(j)){
                    List<Integer> a = new ArrayList<>();
                    a.add(i);
                    a.add(j);
                    ans.add(a);
                }

            }
        }
        return ans;

    }

    private void dfs(int[][] matrix, List<List<Boolean>> can_reach, int r, int c){
        if(can_reach.get(r).get(c))
            return;
        can_reach.get(r).set(c, true);
        int x, y;
        for(int i = 0; i<direction.length-1; i++){
            x = r + direction[i];
            y = c + direction[i+1];
            if(x >=0 && x < matrix.length && y>=0 && y<matrix[0].length && matrix[r][c] <= matrix[x][y])
                dfs(matrix, can_reach, x, y);
        }

    }
}
