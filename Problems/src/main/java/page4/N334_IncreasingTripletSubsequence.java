/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/30 23:46
 */

package page4;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 *     Return true if there exists i, j, k
 *     such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 *
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: true
 *
 * Example 2:
 * Input: [5,4,3,2,1]
 * Output: false
 */
public class N334_IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        // one 代表第一个数，two 代表第二个数，two 保持大于 one
        int one = nums[0], two = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            // 如果出现一个数大于 two，即说明符合题目要求，有三个递增的数
            if (nums[i] > two) {
                return true;
            }

            // 如果新数小于 one，将 one 值更新，如果新数在 one 与 two 之间，更新 two 的值
            // 这里做的目的在于：更新了的 one & two，对比原先的 one & two 值都更小，更可能找到第三个数
            // 如果新的组合都找不到第三个数，则旧的组合也找不到第三个数
            if (nums[i] < one) {
                one = nums[i];
            } else if (nums[i] != one){
                two = Math.min(two, nums[i]);
            }
        }

        return false;
    }
}
