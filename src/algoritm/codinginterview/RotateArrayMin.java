package algoritm.codinginterview;
/*
* 剑指offer 11. 旋转数组的最小数字
* https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class RotateArrayMin {
    public int minArray(int[] numbers){
        int left =0, right = numbers.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(numbers[mid] < numbers[right])
                right = mid;
            else if(numbers[mid] > numbers[right])
                left = mid+1;
            else
                right-=1;


        }
        return numbers[left];
    }
}
