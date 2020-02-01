/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/21 23:52
 */

package page6;

import java.util.Arrays;

/**
 * Given an integer array, you need to find one continuous subarray that
 * if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * <p>
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * <p>
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class N581_ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
//        System.out.println(new N581_ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
//        System.out.println(new N581_ShortestUnsortedContinuousSubarray().findUnsortedSubarray1(new int[]{2, 6, 4, 8, 10, 9, 15}));
//        System.out.println(new N581_ShortestUnsortedContinuousSubarray().findUnsortedSubarray2(new int[]{2, 6, 4, 8, 10, 9, 15}));
//        System.out.println(new N581_ShortestUnsortedContinuousSubarray().findUnsortedSubarray2(new int[]{2, 3, 3, 2, 4}));
        System.out.println(new N581_ShortestUnsortedContinuousSubarray().findUnsortedSubarray2(new int[]{1, 3, 2, 2, 2}));
        System.out.println(new N581_ShortestUnsortedContinuousSubarray().findUnsortedSubarray2(new int[]{1, 3, 2, 3, 3}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    left = Math.min(i, left);
                    right = Math.max(j, right);
                }
            }
        }
        return left > right ? 0 : right - left + 1;
    }

    public int findUnsortedSubarray1(int[] nums) {
        int[] sortNums = nums.clone();
        Arrays.sort(sortNums);
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortNums[i]) {
                left = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != sortNums[i]) {
                right = i;
                break;
            }
        }
        return left > right ? 0 : right - left + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                break;
            }
        }
        if (i == nums.length - 1) {
            return 0;
        }
        int minValueOfUnSortSubArray = Integer.MAX_VALUE;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] < minValueOfUnSortSubArray) {
                minValueOfUnSortSubArray = nums[j];
            }
        }

        int k = nums.length - 1;
        for (; k > 0; k--) {
            if (nums[k] < nums[k - 1]) {
                break;
            }
        }
        int maxValueOfUnSortSubArray = Integer.MIN_VALUE;
        for (int j = k - 1; j >= 0; j--) {
            if (nums[j] > maxValueOfUnSortSubArray) {
                maxValueOfUnSortSubArray = nums[j];
            }
        }

        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int z = 0; z <= i; z++) {
            if (nums[z] > minValueOfUnSortSubArray) {
                left = z;
                break;
            }
        }
        for (int z = nums.length - 1; z >= k; z--) {
            if (nums[z] < maxValueOfUnSortSubArray) {
                right = z;
                break;
            }
        }

        return left > right ? 0 : right - left + 1;
    }
}
