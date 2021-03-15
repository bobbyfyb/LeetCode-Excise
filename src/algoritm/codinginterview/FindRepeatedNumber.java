package algoritm.codinginterview;
/*
* 剑指offer 03. 数组中的重复数字
* https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */

import java.util.HashMap;
import java.util.Map;

public class FindRepeatedNumber {
//    O(n)时间复杂度 O(n)空间复杂度
    public int findRepeatedNumber(int[] nums){
        Map<Integer, Integer> m = new HashMap<>();
        for(int num : nums){
            if(m.containsKey(num))
                return num;
            m.put(num, 1);
        }
        return -1;
    }

//    O(n)时间复杂度 O(1)空间复杂度
    public int findRepeatedNumber2(int[] nums){

        for(int i = 0; i<nums.length;++i){
            int m = nums[i];
            if(m != i){
                int n = nums[m];
                if(m == n)
                    return m;
                else{
                    int temp = nums[m];
                    nums[m] = m;
                    nums[i] = temp;
                }
            }
        }
        return -1;
    }


}
