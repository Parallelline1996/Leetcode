/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/10 22:41
 */

package page2;

import tools.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 * Example 2:
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class N129_SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root, 0);
    }

    private int helper(TreeNode root, int lastSum) {
        if (root == null) {
            return 0;
        }

        int curSum = lastSum * 10 + root.val;
        // leaf node, return
        if (root.left == null && root.right == null) {
            return curSum;
        }

        return helper(root.left, curSum) + helper(root.right, curSum);
    }

    /**
     * 10ms
     */
    public int sumNumbers1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper1(root, "");
    }

    public int helper1(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            return Integer.parseInt(s + root.val);
        }

        int left = 0, right = 0;
        if (root.left != null) {
            left = helper1(root.left, s + root.val);
        }

        if (root.right != null) {
            right = helper1(root.right, s + root.val);
        }

        return left + right;
    }
}
