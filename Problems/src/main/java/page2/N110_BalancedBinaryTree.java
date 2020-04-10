/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/10 23:02
 */

package page2;

import tools.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 *     a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *  Return false.
 */
public class N110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return length(root) != -1;
    }

    public int length(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = length(root.left);
        int right = length(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
