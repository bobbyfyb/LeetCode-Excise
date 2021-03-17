package algoritm.codinginterview;
/*
* 剑指offer 10-II 青蛙跳台阶
* https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class Frog {
    public int numWays(int n){
        if(n==0 || n == 1)
            return 1;
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        for(int i = 2; i<=n;++i){
            count[i] = (int)((count[i-1] + count[i-2])%(1e9+7));
        }
        return count[n];
    }
}
