/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2022/2/20 18:16
 */

package page22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
 * <p>
 * Given a 0-indexed integer array nums of length n and an integer k,
 * return the number of pairs (i, j) where 0 <= i < j < n,
 * such that nums[i] == nums[j] and (i * j) is divisible by k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,1,2,2,2,1,3], k = 2
 * Output: 4
 * Explanation:
 * There are 4 pairs that meet all the requirements:
 * - nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
 * - nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
 * - nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
 * - nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4], k = 1
 * Output: 0
 * Explanation: Since no value in nums is repeated, there are no pairs (i,j) that meet all the requirements.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i], k <= 100
 */
public class N2176_CountEqualAndDivisiblePairsInAnArray {

    /**
     * 方法一：暴力法，直接循环破解
     */
    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 方法二：使用map结构，减少遍历的总数
     */
    public int countPairs1(int[] nums, int k) {
        int count = 0;
        Map<Integer, List<Integer>> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.keySet().contains(nums[i])) {
                List<Integer> list = maps.get(nums[i]);
                for (Integer aList : list) {
                    if (aList * i % k == 0) {
                        count++;
                    }
                }
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                maps.put(nums[i], list);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new N2176_CountEqualAndDivisiblePairsInAnArray().countPairs(
                new int[]{3, 1, 2, 2, 2, 1, 3}, 2
        ));

        System.out.println(new N2176_CountEqualAndDivisiblePairsInAnArray().countPairs1(
                new int[]{3, 1, 2, 2, 2, 1, 3}, 2
        ));
    }
}
