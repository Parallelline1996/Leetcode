/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/7 21:55
 */

package page3;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * Given a binary tree, return all root-to-leaf paths.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class N257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        helper(lists, "", root);
        return lists;
    }

    public void helper(List<String> list, String s, TreeNode root) {
        if (root.left == null && root.right == null) {
            list.add((s + "->" + root.val).substring(2));
            return;
        }

        String temp = s + "->" + root.val;
        if (root.left != null) {
            helper(list, temp, root.left);
        }
        if (root.right != null) {
            helper(list, temp, root.right);
        }
    }
}
