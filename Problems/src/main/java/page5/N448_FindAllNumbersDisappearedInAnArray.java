/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/22 20:54
 */

package page5;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 *
 */
public class N448_FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] isContain = new boolean[nums.length];
        for (int num : nums
                ) {
            isContain[num - 1] = true;
        }

        List<Integer> response = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!isContain[i]) {
                response.add(i + 1);
            }
        }
        return response;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]) - 1;
            if (nums[temp] > 0) {
                nums[temp] = -nums[temp];
            }
        }
        List<Integer> response = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                response.add(i + 1);
            }
        }
        return response;
    }
}
