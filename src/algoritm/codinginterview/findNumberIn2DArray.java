package algoritm.codinginterview;
/*
* 剑指offer 04. 二维数组中的查找
* https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix.length, m = matrix[0].length, x=0, y=m-1;
        while(x<n && y>=0){
            int base = matrix[x][y];
            if(base == target)
                return true;
            else if(base > target)
                --y;
            else
                ++x;
        }
        return false;
    }

}
