package algoritm.binarysearch;
/*
* https://leetcode-cn.com/problems/sqrtx/
 */
public class sqrt {
    public int mySqrt(int x) {
        if(x == 0) return x;
        int l=1, r=x, mid, sqrt;
        while(l<=r){
            mid = (l+r)/2;
            sqrt = mid * mid;
            if(sqrt > x)
                r = mid;
            else if(sqrt<x)
                l = mid+1;
            else
                return mid;
        }
        return l;
    }
}
