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
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * <p>
 * Example 2:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class N98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidNode(root, null, null);
    }

    public boolean isValidNode(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.val <= min || max != null && node.val >= max) {
            return false;
        }

        // 对BST树的翻译：
        // 左子树最大值为当前节点的值
        // 右子树最小值为当前节点的值
        return isValidNode(node.left, min, node.val) && isValidNode(node.right, node.val, max);
    }

    /**
     * 前序遍历后，判断创建的数组是否递增的思路
     */
    public boolean isValidBST1(TreeNode root) {
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
