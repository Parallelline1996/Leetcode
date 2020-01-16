/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/1/16 22:51
 */

package page3;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.
 * <p>
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2
 * <p>
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 * <p>
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class N287_FindTheDuplicateNumber {

    public static void main(String[] args) {
        System.out.println(new N287_FindTheDuplicateNumber().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new N287_FindTheDuplicateNumber().findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    /**
     * 思路：将各个数值放入到对应的下标处，
     * 则一定会出现两个数需要放入同一个下标处的情况
     * 则该数为重复的数
     */
    public int findDuplicate(int[] nums) {
        int duplicateNum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 数字已放置在对应的下标处，value为 i 放置在 i - 1 的下标处
            if (nums[i] == i + 1) {
                continue;
            }

            // temp 为该数字应放置下标处的值
            int temp = nums[nums[i] - 1];

            // 如果出现两个相同的数需要放入到同一个下标处，则该数为重复数
            if (temp == nums[i]) {
                duplicateNum = temp;
                break;
            }

            // 交换两数，继续从该下标处往后遍历
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
            i--;
        }
        return duplicateNum;
    }
}
