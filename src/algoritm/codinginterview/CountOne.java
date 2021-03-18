package algoritm.codinginterview;
/*
* 剑指offer 15. 二进制中1的个数
* https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class CountOne {
    public int hammingWeight(int n) {
        int count = 0, flag = 1;
        while(flag!=0){
            if((n & flag) != 0)
                count++;
            flag = flag << 1;
        }
        return count;

    }
//一个整数减去1后再和原来的自己做位与运算相当于把整数的二进制表示中最右边的1变成0
    public int hammingWeight2(int n) {
        int count = 0;
        while(n != 0){
            ++count;
            n = (n - 1)&n;
        }
        return count;
    }
}
