package array;

import java.util.LinkedList;
import java.util.List;

public class Q989AddToArrayFormOfInteger {

    //Difficulty: Easy
    //TAG: array

    /**
     * 989. Add to Array-Form of Integer
     * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].
     *
     * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
     *
     *
     *
     * Example 1:
     *
     * Input: A = [1,2,0,0], K = 34
     * Output: [1,2,3,4]
     * Explanation: 1200 + 34 = 1234
     * Example 2:
     *
     * Input: A = [2,7,4], K = 181
     * Output: [4,5,5]
     * Explanation: 274 + 181 = 455
     * Example 3:
     *
     * Input: A = [2,1,5], K = 806
     * Output: [1,0,2,1]
     * Explanation: 215 + 806 = 1021
     * Example 4:
     *
     * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
     * Output: [1,0,0,0,0,0,0,0,0,0,0]
     * Explanation: 9999999999 + 1 = 10000000000
     *
     *
     * Note：
     *
     * 1 <= A.length <= 10000
     * 0 <= A[i] <= 9
     * 0 <= K <= 10000
     * If A.length > 1, then A[0] != 0
     */

    /*
    Solution:
    Add two numbers from end to start, and insert at index 0 at LinkedList

    Time: O(max(A, K))
    Space: O(1)
     */

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new LinkedList<>();
        if (A == null) return list;
        int index = A.length - 1, carry = 0;
        while (K > 0 || index >= 0) {
            int digit = (index >= 0 ? A[index] : 0) + K % 10 + carry;
            list.add(0, digit%10);
            carry = digit/10;
            K /= 10;
            index--;
        }
        if (carry > 0) list.add(0, 1);
        return list;
    }

}
