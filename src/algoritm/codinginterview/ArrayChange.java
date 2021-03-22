package algoritm.codinginterview;
/*
* 剑指offer 21. 调整数组使奇数都在前，偶数都在后
* https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */

public class ArrayChange {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length-1;
        while(i<j){
            while(i<j && (nums[i] & 0x1)!=0)
                ++i;
            while(i<j&&(nums[j]&0x1)==0)
                --j;
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }
        return nums;

    }
}
