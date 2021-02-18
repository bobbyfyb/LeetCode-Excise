package algoritm.search;
/*
* https://leetcode-cn.com/problems/number-of-provinces/
 */
import java.util.*;

public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i<n; ++i){
            if(!visited[i]) {
                dfs(isConnected, i, visited);
                ++count;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, boolean[] visited){
        visited[i] = true;
        for(int k = 0; k<isConnected.length; ++k){
            if(isConnected[i][k] == 1 && !visited[k])
                dfs(isConnected, k, visited);
        }
    }
}

