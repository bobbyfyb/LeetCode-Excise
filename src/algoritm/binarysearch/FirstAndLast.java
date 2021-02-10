package algoritm.binarysearch;
/*
* https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1, -1};
        int lower = lowerbound(nums, target), upper = upperbound(nums, target)-1;
        if (lower == nums.length || nums[lower]!=target)
            return new int[]{-1, -1};
        return new int[]{lower, upper};
        }
    private int lowerbound(int[] nums, int target){
        int i = 0, j = nums.length, mid;
        while(i<j){
            mid = (i+j)/2;
            if(nums[mid]>=target)
                j = mid;
            else
                i = mid+1;
        }
        return i;
    }
    private int upperbound(int[] nums, int target){
        int i=0, j= nums.length, mid;
        while(i<j){
            mid = (i+j)/2;
            if(nums[mid]>target){
                j = mid;
            }
            else{
                i = mid+1;
            }
        }
        return i;
    }
}