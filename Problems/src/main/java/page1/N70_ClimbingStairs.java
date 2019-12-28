/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/29 1:06
 */

package page1;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class N70_ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new N70_ClimbingStairs().climbStairs(2));
        System.out.println(new N70_ClimbingStairs().climbStairs(3));
        System.out.println(new N70_ClimbingStairs().climbStairs(10));

        System.out.println(new N70_ClimbingStairs().climbStairs1(2));
        System.out.println(new N70_ClimbingStairs().climbStairs1(3));
        System.out.println(new N70_ClimbingStairs().climbStairs1(10));
    }

    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * space complexity: O(1)
     */
    public int climbStairs1(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
