package algoritm.codinginterview;
/*
* 剑指offer 10-1 斐波那契数列
* https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class FibArray {
    public int fib(int n){
        if(n==0||n==1)
            return n;
        int[] fib = new int[n+1];
        fib[1] = 1;
        for(int i = 2;i<=n;++i)
            fib[i] = (int) ((fib[i-1] + fib[i-2])%(1e9+7));

        return fib[n];
    }
}
