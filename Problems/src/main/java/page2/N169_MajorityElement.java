/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/29 17:31
 */

package page2;

import java.util.Hashtable;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 */
public class N169_MajorityElement {

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
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length / 2;
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int a : nums
                ) {
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
