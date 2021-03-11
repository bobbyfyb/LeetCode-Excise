package algoritm.dynamic_programming;

import java.util.Arrays;

public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix){
        if(matrix.length ==0)
            return new int[0][];
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] d:dp)
            Arrays.fill(d, Integer.MAX_VALUE-1);
        for(int i = 0; i<n; ++i){
            for(int j = 0; j<m; ++j){
                if(matrix[i][j] == 0)
                    dp[i][j] = 0;
                else{
                    if(j > 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
                    if(i > 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                }
            }
        }
        for(int i = n-1; i>=0; --i){
            for(int j = m-1; j>=0; --j){
                if(matrix[i][j]!=0){
                    if(j<m-1)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
                    if(i<n-1)
                        dp[i][j]=Math.min(dp[i][j], dp[i+1][j] + 1);
                }
            }
        }
        return dp;
    }
}
