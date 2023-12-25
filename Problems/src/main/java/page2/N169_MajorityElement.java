/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/29 17:31
 */

package page2;

import java.util.Hashtable;

/**
 * https://leetcode.com/problems/majority-element
 * <p>
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class N169_MajorityElement {

    /**
     * 1ms
     * 思路：因为目标数字至少存在1/2以上，所以采用即使将所有非目标数据与目标数据进行抵消，最终剩余的也是目标的数字
     * 因此直接假定第一个数字就是目标数据，进行抵消
     */
    public int majorityElement(int[] nums) {
        int numOfResult = 0, times = 0;
        for (int num : nums) {
            if (times == 0) {
                numOfResult = num;
                times++;
                continue;
            }

            if (num == numOfResult) {
                times++;
            } else {
                times--;
            }
        }

        return numOfResult;
    }

    /**
     * According to the meaning of the question,
     * the majority element is greater than the sum of the number of other numbers.
     * Therefore, traverse the array, when the values of two numbers are different, cancel.
     * The remain number must the majority element.
     */
    public int majorityElement1(int[] nums) {
        int temp = nums[0], times = 0;
        for (int num : nums) {
            if (times == 0) {
                temp = num;
            }
            if (temp == num) {
                times++;
            } else {
                times--;
            }
        }
        return temp;
    }

    /**
     * Use HashTable to count the element`s number, then find out the majority element
     */
    public int majorityElement2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length / 2;
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int a : nums) {
            if (hashtable.containsKey(a)) {
                int number = hashtable.get(a);
                number++;
                if (number > n) {
                    return a;
                } else {
                    hashtable.put(a, number);
                }
            } else {
                hashtable.put(a, 1);
            }
        }
        return 0;
    }
}
