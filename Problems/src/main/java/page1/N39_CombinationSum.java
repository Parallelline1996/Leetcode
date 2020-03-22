/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/22 0:48
 */

package page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *     All numbers (including target) will be positive integers.
 *     The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class N39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target < 0) {
            return output;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), output);
        return output;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> lists) {
        for (int i = index; i < candidates.length; i++) {
            if (target == candidates[i]) {
                list.add(candidates[i]);
                lists.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }

            if (target < candidates[i]) {
                return;
            }
            list.add(candidates[i]);
            helper(candidates, i, target - candidates[i], list, lists);
            list.remove(list.size() - 1);
        }
    }
}
