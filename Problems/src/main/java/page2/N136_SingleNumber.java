/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/29 0:16
 */

package page2;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 */
public class N136_SingleNumber {

    public static void main(String[] args) {
        System.out.println(new N136_SingleNumber().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    /**
     * use XOR to eliminate numbers that appear twice
     */
    public int singleNumber(int[] nums) {
        int output = 0;
        for (int i : nums
             ) {
            output ^= i;
        }
        return output;
    }
}
