package algoritm.search;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge {
    int[] direction = new int[]{-1, 0, 1, 0, -1};
    public int shortestBridge(int[][] A){
        int m = A.length, n = A[0].length;
        Queue<int[]> points = new ArrayDeque<>();
        boolean flipped = false;
        for(int i = 0; i<m; i++){
            if(flipped) break;
            for(int j = 0; j<n; j++){
                if(A[i][j] == 1){
                    dfs(points, A, m, n, i, j);
                    flipped = true;
                    break;
                }
            }
        }

        int x, y = 0;
        int level = 0;
        while(!points.isEmpty()){
            ++level;
            int n_points = points.size();
            while(n_points-- > 0){
                int[] point = points.poll();
                int r = point[0], c = point[1];
                for(int k = 0; k<4; k++){
                    x = r + direction[k];
                    y = c + direction[k+1];
                    if(x>=0 && y>=0 && x<m && y<n){
                        if(A[x][y] == 2)
                            continue;
                        if(A[x][y] == 1)
                            return level;
                        points.add(new int[]{x, y});
                        A[x][y] = 2;
                    }
                }
            }
        }
        return 0;
    }
    void dfs(Queue<int[]> points, int[][] A, int m, int n, int i, int j){
        if(i < 0 || j < 0 || i==m || j==n || A[i][j] == 2)
            return;
        if(A[i][j] == 0){
            points.add(new int[]{i, j});
            return;
        }
        A[i][j] = 2;
        dfs(points, A, m, n, i-1, j);
        dfs(points, A, m, n, i+1, j);
        dfs(points, A, m, n, i, j-1);
        dfs(points, A, m, n, i, j+1);

    }


}
