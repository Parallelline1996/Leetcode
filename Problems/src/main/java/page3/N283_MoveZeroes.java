/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2019/12/23 22:51
 */

package page3;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 */
public class N283_MoveZeroes {

    /**
     * use index to record the next nonzero position
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != index) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
         }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new N283_MoveZeroes().moveZeroes(nums);
        for (int i : nums
                ) {
            System.out.print(i + "  ");
        }
        System.out.println();

        nums = new int[]{1};
        new N283_MoveZeroes().moveZeroes(nums);
        for (int i : nums
                ) {
            System.out.print(i + "  ");
        }
        System.out.println();

        nums = new int[]{5, 1, 5, 0, 3, 12};
        new N283_MoveZeroes().moveZeroes(nums);
        for (int i : nums
                ) {
            System.out.print(i + "  ");
        }
        System.out.println();

        nums = new int[]{1, 2, 0, 0, 0, 0, 0, 5};
        new N283_MoveZeroes().moveZeroes(nums);
        for (int i : nums
                ) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}
