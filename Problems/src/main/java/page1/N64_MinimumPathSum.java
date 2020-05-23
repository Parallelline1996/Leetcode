/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/5/24 0:03
 */

package page1;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class N64_MinimumPathSum {

    /**
     * dp, 1ms
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = compute(dp, i, j) + grid[i][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    private int compute(int[][] dp, int i, int j) {
        if (i == 0 && j == 0) {
            return 0;
        }

        if (i == 0) {
            return dp[i][j - 1];
        }

        if (j == 0) {
            return dp[i - 1][j];
        }

        return Math.min(dp[i - 1][j], dp[i][j - 1]);
    }
}
