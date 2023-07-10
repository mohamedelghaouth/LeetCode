package Java.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class productOfArrayExceptSelf {

    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     *
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     *
     * Example 1:
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     *
     * Example 2:
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     *
     **/

     /**
      *     ________________________SOLUTION_______________________________
      * For any nums[i], calculate its left product and calculate its right product, without including nums[i].
      * Then multiply these left and right product, This will give product of array excluding nums[i].
      */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int cum = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] =  cum;
            cum *= nums[i];
        }
        cum = 1;

        for (int i = nums.length -1; i>= 0; i--) {
            res[i] =  res[i] * cum;
            cum *= nums[i];
        }
        return res;
    }
}
