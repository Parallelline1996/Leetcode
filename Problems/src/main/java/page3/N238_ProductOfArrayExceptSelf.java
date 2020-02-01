/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/1/27 10:52
 */

package page3;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * <p>
 * Note: Please solve it without division and in O(n).
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class N238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] array = new N238_ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println();

        int[] array1 = new N238_ProductOfArrayExceptSelf().productExceptSelf1(new int[]{1, 2, 3, 4});
        for (int i : array1) {
            System.out.print(i + "  ");
        }
        System.out.println();

        int[] array2 = new N238_ProductOfArrayExceptSelf().productExceptSelf1(new int[]{4, 3, 2, 1, 2});
        for (int i : array2) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    /**
     * O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        int[] output = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = temp;
            temp *= nums[i];
        }

        temp = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = temp;
            temp *= nums[j];
        }

        output[0] = right[0];
        output[output.length - 1] = left[output.length - 1];
        for (int i = 1; i < output.length - 1; i++) {
            output[i] = left[i] * right[i];
        }
        return output;
    }

    /**
     * O(1)
     */
    public int[] productExceptSelf1(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        int[] output = new int[nums.length];

        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            output[i] = temp;
            temp *= nums[i];
        }

        temp = nums[nums.length - 1];
        for (int j = nums.length - 2; j > 0; j--) {
            output[j] *= temp;
            temp *= nums[j];
        }

        output[0] = temp;
        return output;
    }
}
