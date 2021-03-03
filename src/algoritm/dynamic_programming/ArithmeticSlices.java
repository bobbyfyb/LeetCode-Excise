package algoritm.dynamic_programming;
/*
* https://leetcode-cn.com/problems/arithmetic-slices/
 */
import java.util.Arrays;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3)
            return 0;
        int[] dp = new int[n];
        for(int i = 2;i<n;++i){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
                dp[i] = dp[i-1] + 1;
        }
        return Arrays.stream(dp).sum();
    }
}
