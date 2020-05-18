/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/5/18 22:52
 */

package page2;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */
public class N120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            List<Integer> list = triangle.get(i);
            dp[i] = dp[i - 1] + list.get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);
            }
            dp[0] += list.get(0);
        }

        int min = Integer.MAX_VALUE;
        for (int i : dp
             ) {
            min = Math.min(min, i);
        }

        return min;
    }
}
