/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/4 0:10
 */

package page1;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Follow up:
 *     A rather straight forward solution is a two-pass algorithm using counting sort.
 *     First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 *     Could you come up with a one-pass algorithm using only constant space?
 */
public class N75_SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // index 当前遍历的下标
        // startOfTwo 2`s的第一位 - 1
        // oneOfZero 0`s的最后一位 + 1
        int index = 0, startOfTwo = nums.length - 1, endOfZero = 0;
        while (index <= startOfTwo) {
            // 为1，直接遍历下一位
            if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 0) {
                // 为0，需与开头进行交换
                // 因为前面的都已遍历过，均为0或1，因此直接交换后，继续往后遍历
                nums[index++] = nums[endOfZero];
                nums[endOfZero++] = 0;
            } else {
                // 为2时，需要跟最末位一位交换位置
                // 因为末位最后一位未处理过，因此index不可+1
                nums[index] = nums[startOfTwo];
                nums[startOfTwo--] = 2;
            }
        }
    }
}
