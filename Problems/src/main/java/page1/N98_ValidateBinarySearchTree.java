/**
 * @Author: parallelline1996
 * @Email: chenyu1996a@163.com
 * @Date: 2020/4/18 11:11
 */

package page1;

import tools.TreeNode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class N98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        inorderTraversal(root, arrayList);

        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i) >= arrayList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arrayList);
        arrayList.add(root.val);
        inorderTraversal(root.right, arrayList);
    }
}
