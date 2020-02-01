/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/1/24 9:57
 */

package page1;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class N1_TwoSum {

    /**
     * 思路：由于需要输出下标值，使用一个 map数据结构，Key为值，value为值对应的下标
     * 遍历一遍数组，判断 map中是否有跟当前值相加为所需值的数
     * 若有，则返回对应下标，若无，则添加该值和下标值到 map中
     */
    public int[] twoSum(int[] nums, int target) {
        // 对输入进行判断，若为空或数组长度小于二，直接返回
        if (nums == null || nums.length < 2) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int remainValue = target - nums[i];
            if (map.containsKey(remainValue)) {
                return new int[]{map.get(remainValue), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
