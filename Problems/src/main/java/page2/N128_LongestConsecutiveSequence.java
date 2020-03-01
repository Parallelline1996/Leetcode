/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/27 22:31
 */

package page2;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * <p>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class N128_LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(new N128_LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums
        ) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums
        ) {
            if (!set.contains(num - 1)) {
                int temp = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    temp++;
                }
                max = Math.max(max, temp);
            }
        }
        return max;
    }



}
