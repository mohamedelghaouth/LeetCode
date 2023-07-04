package Java.solutions;

import java.util.HashSet;
import java.util.Set;


/*
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<String> set = new HashSet<String>();

        for(int i = 0; i < nums.length; i++ ){
            set.add(nums[i] + "");
        }
        
        return set.size() != nums.length;
    }
}