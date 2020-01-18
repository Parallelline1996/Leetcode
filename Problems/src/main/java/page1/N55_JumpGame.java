/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/1/17 23:21
 */

package page1;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * <p>
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class N55_JumpGame {

    public static void main(String[] args) {
        System.out.println(new N55_JumpGame().canJump(new int[]{2, 0}));
        System.out.println(new N55_JumpGame().canJump(new int[]{2}));
        System.out.println(new N55_JumpGame().canJump(new int[]{0}));
        System.out.println(new N55_JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new N55_JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    /**
     * 思路：通过不断更新当前能达到的可达最大下标值，来判断能否到达数组的最大下标处：
     * 当可达最大下标值超过数组最大下标时，即可以达到最大的下标处
     * 当出现遍历到下标为i的时候，当前的可达最大下标值小于i时，则不可以达到最大的下标处
     */
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 可达最大下标值大于当前遍历的下标值，则说明该下标无法被到达
            if (maxIndex < i) {
                return false;
            }

            // 更新可达最大下标值
            maxIndex = Math.max(maxIndex, i + nums[i]);

            // 可达最大下标值不小于数组最大下标值，则说明可以到达最后一个位置
            if (maxIndex >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
