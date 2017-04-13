package Problem1To10;

import java.util.HashMap;

public class Two_Sum {
    /**
    1. Two Sum
     Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:
     Given nums = [2, 7, 11, 15], target = 9,
     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
     */

    /**
     * Solution 1: Brute force high time, low space
     * Two loops, which outer loop start from begin to the last second element, inner loop from next element of current i to the end of array, when met the target, return the new build array
     *
     * Time: Get inner j loop as pivot, n represent the length of array, O(n - 1) + O(n - 2) + ... + O(1) = O(n(n + 1)/2) = O(n^2)
     * Space: O(2) new alloc 2 space result array = O(1)
     */

    public int[] twoSumS1(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0) return res;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return res;
    }

    /**
     * Solution 2: HashMap high space, low time
     * Use hashMap to record current value pairs with current index, one loop to iterative the array to find rest of number which could add to target or record current number
     *
     * Time: O(n) n represent the length of array
     * Space: O(n) the worst case the when find the result at the end of array or find no result after iterative all the array
     */

    public int[] twoSumS2(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //Use map to check if rest of number minus from target is already in the hashMap
            int resNum = target - nums[i];
            if (map.containsKey(resNum)) return new int[]{i, map.get(resNum)};
            else map.put(nums[i], i);
        }
        return res;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int curSum = numbers[i] + numbers[j];
            if (curSum < target) i++;
            else if (curSum > target) j--;
            else return new int[]{i + 1, j + 1};
        }
        return res;
    }

}
