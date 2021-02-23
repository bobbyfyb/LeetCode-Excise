package algoritm.search;

public class WordSearch {
    boolean find = false;
    public boolean exist(char[][] board, String word) {
        if(board.length==0||board[0].length==0)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                dfs(i, j, board, word, this.find, visited, 0);
            }
        }
        return this.find;
    }
    private void dfs(int i, int j, char[][] board, String word, boolean find, boolean[][] visited,int pos) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if(visited[i][j] || find || board[i][j] != word.charAt(pos))
            return;
        if (pos == word.length() - 1) {
            this.find = true;
            return;
        }
        visited[i][j] = true;
        dfs(i+1, j, board, word, this.find, visited, pos+1);
        dfs(i-1, j, board, word, this.find, visited, pos+1);
        dfs(i, j+1, board, word, this.find, visited, pos+1);
        dfs(i, j-1, board, word, this.find, visited, pos+1);
        visited[i][j] = false;

    }

    public static void main(String[] args) {
        boolean find = new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
    }
}
