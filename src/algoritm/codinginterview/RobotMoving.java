package algoritm.codinginterview;

public class RobotMoving {
    public int movingCount(int m, int n, int k){
        int[][] board = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i<m; ++i){
            for(int j = 0; j < n; ++j)
                board[i][j] = i/10 + i%10 + j/10 + j%10;
        }
        int x = 0, y = 0, count = 0;
        while(x>=0 || x<m || y>=0 || y<n){
            count = dfs(board, visited,x, y, m, n, count, k);
        }
        return count;
    }

    private int dfs(int[][] board, boolean[][] visited,int x, int y, int m, int n, int count, int k){
        if(x<0 || x>=m || y<0 || y>=n||board[x][y]>k )
            return 0;
        ++count;
        visited[x][y] = true;
        count = dfs(board, visited, x+1, y, m, n, count, k) + dfs(board, visited, x, y+1, m, n, count,k)+
                dfs(board, visited, x-1, y, m, n, count, k) + dfs(board, visited, x, y-1, m, n, count, k);
        return count;

    }
}
