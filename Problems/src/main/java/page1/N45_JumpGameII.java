/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/1/17 23:40
 */

package page1;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Note:
 * You can assume that you can always reach the last index.
 */
public class N45_JumpGameII {

    public static void main(String[] args) {
        System.out.println(new N45_JumpGameII().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new N45_JumpGameII().jump1(new int[]{2, 3, 1, 1, 4}));
    }

    /**
     * O(n²)
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        return dp[nums.length - 1];
    }

    /**
     * 思路：判断每增加一次跳跃，能达到的最远距离是否超过了数组的最大下标
     */
    public int jump1(int[] nums) {
        // 跳跃的步数
        int steps = 0;
        // 当前步数可到达的最大下标
        int maxIndex = 0;
        // 增加一步可以到达的最大下标
        int nextIndex = nums[0];

        for (int i = 0; i < nums.length; i++) {
            // 当前遍历的下标值已经超过了当前步数可达的最大下标
            if (i > maxIndex) {
                steps++;
                if (nextIndex >= nums.length - 1) {
                    break;
                } else {
                    maxIndex = nextIndex;
                }
            }

            // 更新下一步能到达最大下标
            nextIndex = Math.max(nextIndex, i + nums[i]);
        }

        return steps;
    }
}
