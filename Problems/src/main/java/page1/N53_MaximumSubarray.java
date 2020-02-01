/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/1/28 21:55
 */

package page1;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class N53_MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(new N53_MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
     * <p>
     * 思路：取一个局部最优，跟一个全局最优。
     * 遍历每一个数，判断是否将这个数加入，或者是新起一个新的字串，来获取局部最优
     */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int localMax = nums[0];
        int totalMax = localMax;
        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            if (totalMax < localMax) {
                totalMax = localMax;
            }
        }
        return totalMax;
    }

    /**
     * 动态规划
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        // 定义为以第 i点为最后一个元素的子数组的能获得的最大值
        int[] dp = new int[nums.length];

        // 初始化
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            // 判断是否要包含当前节点之前的其他节点
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
