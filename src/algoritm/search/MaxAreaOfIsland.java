package algoritm.search;
/*
* https://leetcode-cn.com/problems/max-area-of-island/
 */
import javafx.util.Pair;

import java.util.Stack;

public class MaxAreaOfIsland {
    int[] direction = new int[]{-1, 0, 1, 0, -1};
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length, n = m!=0?grid[0].length:0, localarea, area=0, x, y;
        for(int i = 0;i<m; ++i){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==1){
                    localarea = 1;
                    grid[i][j] = 0;
                    Stack<Pair<Integer, Integer>> island = new Stack<>();
                    island.push(new Pair<>(i, j));
                    while(!island.isEmpty()){
                        Pair<Integer, Integer> point = island.pop();
                        for(int k = 0; k<direction.length-1; k++){
                            x = point.getKey() + direction[k];
                            y = point.getValue() + direction[k+1];
                            if(x>=0 && x<m && y>=0 && y<n &&grid[x][y]==1){
                                island.push(new Pair<>(x, y));
                                ++localarea;
                                grid[x][y] = 0;
                            }
                        }
                    }
                    area = Math.max(area, localarea);
                }
            }
        }
        return area;

    }
    public int maxAreaOfIsland2(int[][] grid){

        if(grid.length ==0 || grid[0].length ==0)
            return 0;
        int max_area = 0;
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){
                if(grid[i][j] == 1) {
                    max_area = Math.max(max_area, dfs(grid, i, j));
                }
            }
        }
        return max_area;
    }

    private int dfs(int[][] grid, int i, int j){
        if(grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        int x, y, area = 1;
        for(int k = 0; k < direction.length-1; ++k){
            x = i + direction[k];
            y = j + direction[k+1];
            if(x>=0 && x< grid.length && y>=0 && y<grid[0].length)
                area += dfs(grid, x, y);
        }
        return area;
    }

}
