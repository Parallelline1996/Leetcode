/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/7 21:37
 */

package page2;

import tools.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class N145_BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            lists.add(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }

            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        Collections.reverse(lists);
        return lists;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp = null;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            lists.addFirst(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return lists;
    }
}
