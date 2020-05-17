/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/5/17 20:01
 */

package page10;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 *
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 * A falling path starts at any element in the first row, and chooses one element from each row.
 * The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 * Example 1:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 *
 *     [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 *     [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 *     [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 *
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 *
 * Note:
 *     1 <= A.length == A[0].length <= 100
 *     -100 <= A[i][j] <= 100
 */
public class N931_MinimumFallingPathSum {

    /**
     * 思路：
     * 常规的动态规划的题目，状态转换方程也比较容易确定：
     *
     * 当 i = 0 时：
     * dp[i][j] = A[i][j]
     * 当 i > 0 时：
     * dp[i][j] = min(dp[i][j-1], dp[i][j], dp[i][j + 1]) + A[i][j]
     *
     * 最后通过比较最后一排的值，求出 min falling path sum
     */
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = A[i][j];
                    continue;
                }

                dp[i][j] = compute(dp, i, j) + A[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            min = Math.min(min, dp[A.length - 1][i]);
        }
        return min;
    }

    private int compute(int[][] dp, int i, int j) {
        int min = dp[i - 1][j];
        if (j > 0) {
            min = Math.min(min, dp[i - 1][j - 1]);
        }

        if (j + 1 < dp[0].length) {
            min = Math.min(min, dp[i - 1][j + 1]);
        }

        return min + dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new N931_MinimumFallingPathSum().minFallingPathSum(new int[][]{
                {1,2,3}, {4,5,6}, {7,8,9}
        }));
    }
}
