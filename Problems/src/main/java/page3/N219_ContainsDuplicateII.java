/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/31 22:09
 */

package page3;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 *
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class N219_ContainsDuplicateII {

    /**
     * 10ms
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k){
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * 6ms
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (; i < nums.length && i < k; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }

        for (int j = 0; i < nums.length; i++, j++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
                set.remove(nums[j]);
            }
        }
        return false;
    }

    /**
     * 1000+ ms
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
