package algoritm.dynamic_programming;
/*
* https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<=2)
            return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i< dp.length;++i)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];

    }

    public int climStairs2(int n){
        if(n<=2)
            return n;
        int pre2 = 1, pre1=2, cur=0;
        for(int i=2; i<n; i++){
            cur = pre2 + pre1;
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}
