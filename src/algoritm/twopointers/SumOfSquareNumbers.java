package algoritm.twopointers;
/*
* https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int)Math.sqrt(c);
        while(l<=r){
            int sum = l*l + r*r;
            if(sum == c)
                return true;
            else if(sum > c)
                --r;
            else
                ++l;
        }
        return false;
    }
}
