package algoritm.twopointers;
/*
* https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum < target)
                i++;
            else if(sum>target)
                j--;
            else
                break;
        }
        return new int[]{i+1, j+1};
    }
}
