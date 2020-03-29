/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/28 20:42
 */

package page1;

import java.util.*;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 * Input: [1,2,0]
 * Output: 3
 *
 * Example 2:
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class N41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                // important
                i--;
            }
        }

        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                break;
            }
        }
        return i + 1;
    }

    private void swap(int[] number, int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }

    /**
     * O(n) space
     */
    public int firstMissingPositive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums
             ) {
            set.add(i);
        }

        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        return i;
    }
}
