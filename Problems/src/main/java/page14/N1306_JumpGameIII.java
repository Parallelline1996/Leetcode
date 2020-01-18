/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/1/18 0:03
 */

package page14;

import java.util.HashSet;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * Notice that you can not jump outside of the array at any time.
 *
 * Example 1:
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 *
 * Example 2:
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 *
 * Example 3:
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 *
 * Constraints:
 *     1 <= arr.length <= 5 * 10^4
 *     0 <= arr[i] < arr.length
 *     0 <= start < arr.length
 */
public class N1306_JumpGameIII {

    public static void main(String[] args) {
        System.out.println(new N1306_JumpGameIII().canReach(new int[]{3, 0, 2, 1, 2}, 2));
        System.out.println(new N1306_JumpGameIII().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(new N1306_JumpGameIII().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
    }

    private HashSet<Integer> set = new HashSet<>();

    public boolean canReach(int[] arr, int index) {
        // set中已有该下标，则说明出现循环，退出
        if (index < 0 || index > arr.length - 1 || set.contains(index)) {
            return false;
        }

        set.add(index);
        // 判断该点是否为下标值为0的地方，或者index + arr[index]跟index - arr[index] 是否为下标值为0的地方
        if (arr[index] == 0 || canReach(arr, index + arr[index]) || canReach(arr, index - arr[index])) {
            return true;
        }
        set.remove(index);
        return false;
    }
}
