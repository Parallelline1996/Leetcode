/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/5/17 16:01
 */

package page4;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
 * in their binary representation and return them as an array.
 *
 * Example 1:
 * Input: 2
 * Output: [0,1,1]
 *
 * Example 2:
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 * Follow up:
 *     It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 *     Space complexity should be O(n).
 *     Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class N338_CountingBits {

    /**
     * 当前的数字有几个1，为等于减去最高的数字，剩下的数字有几个1再+1（最高位）
     * 例如，0110，有去掉最高的1剩下的0010有1个1，再加上1，共2个1
     */
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }

        int[] dp = new int[num + 1];
        for (int i = 1, j = 2; i <= num ; i++) {
            if (i == j) {
                dp[i] = 1;
                j *= 2;
                continue;
            }
            dp[i] = dp[i - j / 2] + 1;
        }
        return dp;
    }
}
