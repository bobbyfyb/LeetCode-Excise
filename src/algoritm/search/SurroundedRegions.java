package algoritm.search;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int n = board.length;
        if(n==0)
            return;
        int m = board[0].length;
        for(int i=0; i<n; ++i){
            dfs(board, n, m, i, 0);
            dfs(board, n, m, i, m-1);
        }
        for(int i =0; i<m; ++i){
            dfs(board, n, m, 0, i);
            dfs(board, n, m, n-1, i);
        }
        for(int i = 0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(board[i][j] == 'A')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int n, int m, int x, int y){
        if(x<0 || y<0 || x>=n || y>=m || board[x][y] != 'O'){
            return;
        }
        board[x][y] = 'A';
        dfs(board, n, m, x+1, y);
        dfs(board, n, m, x-1, y);
        dfs(board, n, m, x, y+1);
        dfs(board, n, m, x, y-1);

    }
}
