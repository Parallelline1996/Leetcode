/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/9 21:07
 */

package page10;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 * <p>
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 * <p>
 * Example 1:
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * <p>
 * Example 2:
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * <p>
 * Example 3:
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * <p>
 * Example 4:
 * <p>
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 * <p>
 * Note：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 */
public class N989_AddToArrayFormOfInteger {

    public static void main(String[] args) {
        System.out.println(new N989_AddToArrayFormOfInteger().addToArrayForm(new int[]{1,2,0,0}, 34));
        System.out.println(new N989_AddToArrayFormOfInteger().addToArrayForm(new int[]{2,7,4}, 181));
        System.out.println(new N989_AddToArrayFormOfInteger().addToArrayForm(new int[]{2,1,5}, 806));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> result = new LinkedList<>();
        int add = 0;
        for (int i = A.length - 1; i >= 0 || K > 0 || add != 0; i--) {
            int k = K % 10;
            if (i >= 0) {
                result.addFirst((k + A[i] + add) % 10);
                add = (k + A[i] + add) / 10;
            } else {
                result.addFirst((k + add) % 10);
                add = (k + add) / 10;
            }
            K /= 10;
        }
        return result;
    }
}
