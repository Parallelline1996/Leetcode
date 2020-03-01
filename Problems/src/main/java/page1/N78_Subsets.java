/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/2/28 21:42
 */

package page1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class N78_Subsets {

    public static void main(String[] args) {
        List<List<Integer>> lists = new N78_Subsets().subsets(new int[]{1, 2, 3});
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }

    /**
     * Use binary to identify the occurrence of each number
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append("1");
        }
        int max = Integer.parseInt(sb.toString(), 2);

        for (int i = 0; i <= max; i++) {
            String cur = addZero(Integer.toBinaryString(i), nums.length);

            List<Integer> array = new ArrayList<>();
            for (int j = cur.length() - 1; j >= 0; j--) {
                if (cur.charAt(j) == '1') {
                    array.add(nums[j]);
                }
            }
            output.add(array);
        }
        return output;
    }

    private String addZero(String s, int number) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + s.length() < number) {
            sb.append("0");
        }
        sb.append(s);
        return sb.toString();
    }

    /**
     * better solution
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    private static void backtrack(List<List<Integer>> res, int[] nums, int st, List<Integer> objects) {
        res.add(new ArrayList<>(objects));
        for (int i = st; i < nums.length; i++) {
            objects.add(nums[i]);
            backtrack(res, nums, i + 1, objects);
            objects.remove(objects.size() - 1);
        }
    }
}
