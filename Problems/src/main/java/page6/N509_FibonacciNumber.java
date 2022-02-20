/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2021/3/14 9:06
 */

package page6;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 F(0) = 0, F(1) = 1
 F(n) = F(n - 1) + F(n - 2), for n > 1.
 Given n, calculate F(n).

 Example 1:

 Input: n = 2
 Output: 1
 Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

 Example 2:

 Input: n = 3
 Output: 2
 Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 Example 3:

 Input: n = 4
 Output: 3
 Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.


 Constraints:

 0 <= n <= 30
 */
public class N509_FibonacciNumber {

    /**
     * 暴力递归的思路
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 备忘录的迭代算法
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }

        int[] nums = new int[n + 1];
        return helper(n, nums);
    }

    private int helper(int n, int[] nums) {
        if (n < 2) {
            return n;
        }

        if (nums[n] != 0) {
            return nums[n];
        }

        nums[n] = helper(n - 1, nums) + helper(n - 2, nums);
        return nums[n];
    }

    /**
     * dp数组的迭代算法
     */
    public int fib1(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = build(n);
        return nums[n];
    }

    private int[] build(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums;
    }
}