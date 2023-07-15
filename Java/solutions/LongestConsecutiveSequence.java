package Java.solutions;


import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 * */
public class LongestConsecutiveSequence {

    static public Set<Integer> getSettOfElement(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i: nums) {
            set.add(i);
        }

        return set;
    }

    static public int getNextConsecutive(int i, Set<Integer> set) {
        int length = 1;
        while(set.remove(++i)){
            ++length;
        }
        return length;
    }

    static public boolean isStarter(int i, Set<Integer> set) {
        return !set.contains(i - 1);
    }

    static public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = getSettOfElement(nums);
        for (int elem: nums){
            if(isStarter(elem, set)){
                max = Math.max(max, getNextConsecutive(elem, set));
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums_1 = {100, 4, 200, 1, 3, 2};
        int[] nums_2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums_3 = {1, 2, 0, 1};
        int[] nums_4 = {7,2,-2,9,6,9,-7,2,1,-3,-1,-7,-5};

        int answer1 = longestConsecutive(nums_1);
        int answer2 = longestConsecutive(nums_2);
        int answer3 = longestConsecutive(nums_3);
        int answer4 = longestConsecutive(nums_4);

        assert answer1 == 4: "The Correct answer is 4";
        assert answer2 == 9: "The Correct answer is 9";
        assert answer3 == 3: "The Correct answer is 3";
        assert answer4 == 3: "The Correct answer is 3";

        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
        System.out.println(answer4);
    }
}
