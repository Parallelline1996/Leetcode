/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/19 15:48
 */

package page3;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 */
public class N230_KthSmallestElementInABST {

    /**
     * solution 1: inorder
     * 0ms
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, k, list);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root, int k, List<Integer> list) {
        if (root == null || list.size() >= k) {
            return;
        }
        inorder(root.left, k, list);
        list.add(root.val);
        inorder(root.right, k, list);
    }

    /**
     * solution 2: use stack
     * 2ms
     */
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
