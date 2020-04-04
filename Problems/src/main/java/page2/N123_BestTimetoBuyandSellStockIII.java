/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/4 11:01
 */

package page2;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class N123_BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {
        int b1 = Integer.MIN_VALUE, s1 = 0;
        int b2 = Integer.MIN_VALUE, s2 = 0;
        for (int price : prices) {
            // 第一次买入，支出 price
            b1 = Math.max(b1, -price);
            // 第一次卖出，盈利 price + b1
            s1 = Math.max(s1, price + b1);

            // 第二次买入，受第一次买卖的影响，因此有 s1 的本金，支出 price
            b2 = Math.max(b2, s1 - price);
            // 第二次买入，盈利 price + b2
            s2 = Math.max(s2, price + b2);
        }
        return s2;
    }

    public int maxProfit1(int[] prices) {
        int[] min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] profit = new int[2];

        for (int price : prices) {
            min[0] = Math.min(min[0], price);
            profit[0] = Math.max(profit[0], price - min[0]);

            min[1] = Math.min(min[1], -profit[0] + price);
            profit[1] = Math.max(profit[1], price - min[1]);
        }
        return profit[1];
    }

    /**
     * O(n²), 600+ms
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, countMaxProfit(prices, 0, i) + countMaxProfit(prices, i, prices.length));
        }
        return maxProfit;
    }

    private int countMaxProfit(int[] prices, int start, int end) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = start; i < end; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (prices[i] - minValue > maxProfit) {
                maxProfit = prices[i] - minValue;
            }
        }
        return maxProfit;
    }
}
