/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/3/6 21:55
 */

package page2;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 *
 * Return:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class N113_PathSumII {

    /**
     * solution one:
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        helper(new ArrayList<>(), sum, root, lists);
        return lists;
    }

    private void helper(List<Integer> list, int sum, TreeNode root, List<List<Integer>> lists) {
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                list.add(root.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }

        if (root.left != null) {
            list.add(root.val);
            helper(list, sum - root.val, root.left, lists);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            list.add(root.val);
            helper(list, sum - root.val, root.right, lists);
            list.remove(list.size() - 1);
        }
    }

    /**
     * solution two:
     */
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        pathSum(root, sum, lists, new ArrayList<>());
        return lists;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> lists, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        // 判断为从 root-to-leaves 的串，则判断是否符合题意
        if (root.val == sum && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
        } else {
            // 当前节点为中间节点，则继续往下查看其左右节点
            pathSum(root.left, sum - root.val, lists, list);
            pathSum(root.right, sum - root.val, lists, list);
        }
        // 完成这个节点的遍历返回父节点时，要删除当前节点的值
        list.remove(list.size() - 1);
    }
}
