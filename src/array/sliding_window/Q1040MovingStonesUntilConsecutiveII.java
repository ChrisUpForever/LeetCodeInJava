package array.sliding_window;

import java.util.Arrays;

public class Q1040MovingStonesUntilConsecutiveII {

    //Difficulty: medium
    //TAG: array
    //TAG: sliding window
    //TODO: analyze

    /**
     * 1040. Moving Stones Until Consecutive II
     * On an infinite number line, the position of the i-th stone is given by stones[i].  Call a stone an endpoint stone if it has the smallest or largest position.
     *
     * Each turn, you pick up an endpoint stone and move it to an unoccupied position so that it is no longer an endpoint stone.
     *
     * In particular, if the stones are at say, stones = [1,2,5], you cannot move the endpoint stone at position 5, since moving it to any position (such as 0, or 3) will still keep that stone as an endpoint stone.
     *
     * The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.
     *
     * When the game ends, what is the minimum and maximum number of moves that you could have made?  Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]
     *
     *
     *
     * Example 1:
     *
     * Input: [7,4,9]
     * Output: [1,2]
     * Explanation:
     * We can move 4 -> 8 for one move to finish the game.
     * Or, we can move 9 -> 5, 4 -> 6 for two moves to finish the game.
     * Example 2:
     *
     * Input: [6,5,4,3,10]
     * Output: [2,3]
     * We can move 3 -> 8 then 10 -> 7 to finish the game.
     * Or, we can move 3 -> 7, 4 -> 8, 5 -> 9 to finish the game.
     * Notice we cannot move 10 -> 2 to finish the game, because that would be an illegal move.
     * Example 3:
     *
     * Input: [100,101,104,102,103]
     * Output: [0,0]
     *
     *
     * Note:
     *
     * 3 <= stones.length <= 10^4
     * 1 <= stones[i] <= 10^9
     * stones[i] have distinct values.
     */

    /*
    Solution:

    https://leetcode.com/problems/moving-stones-until-consecutive-ii/discuss/286707/JavaC%2B%2BPython-Sliding-Window

    Sliding window, max step is max - min - (n - 2), means how many blanks need to be filled to be consecutive sequence,
    due to need move start or end to not start/end position actually max is move one end with another continuously, e.g.

    1.2.3.7.9, will be 1.2.3.6.7 -> 1.2.3.5.6 -> 1.2.3.4.5 move 7 and 9 one by one

    min step will be find a sliding window that contains n values by sequence

    Time: O(n)
    Space: O(n)
     */

    public int[] numMovesStonesII(int[] A) {
        Arrays.sort(A);
        int i = 0, n = A.length, low = n;
        //max of last one and last second value step one by one
        int high = Math.max(A[n - 1] - n + 2 - A[1], A[n - 2] - A[0] - n + 2);
        for (int j = 0; j < n; j++) {
            while (A[j] - A[i] >= n) i++;
            if (j - i + 1 == n - 1 && A[j] - A[i] == n - 2)
                low = Math.min(low, 2);
            else
                low = Math.min(low, n - (j - i + 1));
        }
        return new int[] {low, high};
    }

}
