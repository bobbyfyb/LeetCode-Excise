package algoritm.sort;
/*
* https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1, target = nums.length - k;
        while(lo < hi){
            int j = partition(nums, lo, hi);
            if(j  == target)
                return nums[j];
            else if(j > target)
                hi = j - 1;
            else
                lo = j + 1;

        }
        return nums[lo];
    }

    private int partition(int[] nums, int lo, int hi){
        int left = lo+1, right = hi;
        while(true){
            while(left < hi && nums[left]<=nums[lo])
                ++left;
            while(right > lo && nums[right]>=nums[lo])
                --right;
            if(left>=right)
                break;
            swap(nums, left, right);
        }
        swap(nums, lo, right);
        return right;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
