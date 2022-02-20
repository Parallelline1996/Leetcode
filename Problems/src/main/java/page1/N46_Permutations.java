/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/2 22:03
 */

package page1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 *
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class N46_Permutations {

    public static void main(String[] args) {
        List<List<Integer>> output = new N46_Permutations().permute(new int[]{1,2,3});
        for (List<Integer> list : output
             ) {
            for (Integer i : list
                 ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        permute(nums, nums.length, new boolean[nums.length], new ArrayList<>(), output);
        return output;
    }

    /**
     * 回溯算法
     */
    public void permute(int[] nums, int number, boolean[] use, List<Integer> list, List<List<Integer>> output) {
        // 满足结束条件
        if (number == 0) {
            // 在result中添加路径
            output.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!use[i]) {
                // 做选择，并将选择结果从选择列表移除，添加到路径
                list.add(nums[i]);
                use[i] = true;
                permute(nums, number - 1, use, list, output);
                // 撤销选择，从路径中移除选择，并将选择放回到选择列表
                use[i] = false;
                list.remove((Integer)nums[i]);
            }
        }
    }

    /**
     * other solution
     */
    private static List<List<Integer>> permute1(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        permute1(nums, 0, list);
        return list;
    }

    private static void permute1(int[] nums, int start, List<List<Integer>> output) {
        if (start == nums.length - 1) {
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int a : nums
            ) {
                temp.add(a);
            }
            output.add(temp);
        } else {
            // 注意这里要从 start开始，因为还有一开始的序列这种情况
            for (int i = start; i < nums.length; i++) {
                // 进行交换
                swap(nums, start, i);
                // 将开始交换的位向后推动一位 start = start + 1
                permute1(nums, start + 1, output);
                // 交换回来，为了下一次交换
                swap(nums, start, i);
            }
        }
    }

    /**
     * 用于交换的方法
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
