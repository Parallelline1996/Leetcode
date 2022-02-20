/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/26 23:57
 */

package page4;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class N322_CoinChange {

    public static void main(String[] args) {
        System.out.println(new N322_CoinChange().coinChange(new int[]{1,2,5}, 11));
        System.out.println(new N322_CoinChange().coinChange(new int[]{2}, 3));
        System.out.println(new N322_CoinChange().coinChange(new int[]{2}, 1));
    }

    public int coinChange1(int[] coins, int amount) {
        // 异常参数判断
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        // 创建dp[]，dp[n]代表金额n所需要的最少零钱数
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            // 思路类似于上楼梯
            // 可以从不同的金额 + 特定的零钱数 到达当前的金额
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < dp.length; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    continue;
                }
                if (i == coins[j]) {
                    temp = 0;
                    continue;
                }
                temp = Math.min(temp, dp[i - coins[j]]);
            }
            if (temp != Integer.MAX_VALUE) {
                dp[i] = temp + 1;
            }
        }
        return dp[dp.length - 1] == Integer.MAX_VALUE? -1: dp[dp.length - 1];
    }
}
